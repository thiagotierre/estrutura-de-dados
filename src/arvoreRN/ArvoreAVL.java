package arvoreRN;

import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreAVL implements TADArvore {
	
	private No raiz;
	private int size;
	
	private ArrayList<No> inOrder = new ArrayList<No>();
    private ArrayList<No> preOrder = new ArrayList<No>();
    private ArrayList<No> posOrder = new ArrayList<No>();
    
    public ArvoreAVL() {
		this.raiz = null;
		this.size = 0;
	}
    
	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int size() {
		return this.getSize();
	}

	@Override
	public int height(No no) {
		int h;
		if(isExternal(no)) {
			return 0;
		} else {
			h = 0;
			Iterator it = children(no); 
			while(it.hasNext()) {
				No son = (No) it.next();
				h=Math.max(h, height(son));
			}
		}
		return h+1;
	}

	@Override
	public int depth(No no) {
		if(isRoot(no))
			return 0;
		return 1+depth(parent(no));
	}

	@Override
	public Iterator<No> children(No no) {
		ArrayList<No> chil = new ArrayList<No>();
		chil.add(no.getLeftSon());
		chil.add(no.getRightSon());
		return chil.iterator();
	}

	@Override
	public boolean isEmpty() {
		return getRaiz() == null;
	}

	@Override
	public boolean isInternal(No no) {
		return (no==null) ? false : (no.getLeftSon()!=null || no.getRightSon()!=null);
	}

	@Override
	public boolean isExternal(No no) {
		return (no==null) ? true : (no.getLeftSon()==null && no.getRightSon()==null);
	}

	@Override
	public No root() {
		return getRaiz();
	}

	@Override
	public No parent(No no) {
		return no.getFather() !=null ? no.getFather() : root() ;
	}

	@Override
	public No replace(No no, int item) {
        no.setElement(item);
		return no;
	}

	@Override
	public No search(int item) {
		return treeSearch(item, root());
	}
	 
	@Override
	public No treeSearch(int item, No no) {
		if(isExternal(no))
			return no;
		if(item < no.getElement())
			return  (no.getLeftSon()!=null) ? treeSearch(item, no.getLeftSon()) : no;
		else if(item == no.getElement())
			return no;
		else if(item > no.getElement())
			return (no.getRightSon()!=null) ? treeSearch(item, no.getRightSon()) : no;
		else
			return no;
	}

	@Override
	public boolean isRoot(No no) {
		boolean status = false;
		if(no.getFather()==null)
			status = true;
		return status;
	}
	
	public Iterator inOrder(No no) {
		if(isInternal(no)) {
			inOrder(leftChild(no));
			inOrder.add(no);
		} else if(no!=null) {
			inOrder.add(no);
		}
		
		if(isInternal(no)) {
			inOrder(rightChild(no));
		}
		Iterator it = inOrder.iterator(); 
		return it;
	}
	
	public Iterator preOrder(No no) {
		preOrder.add(no);
		
		while(children(no).hasNext())
			preOrder(children(no).next());
		
		return preOrder.iterator();
	}
	
	public Iterator posOrder(No no) {
		while(children(no).hasNext())
			preOrder(children(no).next());
		
		posOrder.add(no);
		
		return posOrder.iterator();
	}
	
    public int height() { 
        return (root()==null?-1:height(root()));
    }
    
    public Iterator inOrder(){
        inOrder = new ArrayList();
        return (root()==null)?null:inOrder(root()); 
    }
    
    public void show() {
    	System.out.println(toString());
    }

	@Override
	public String toString() {
		Iterator itr = inOrder();
        int h = this.height() + 1;
        int l = this.size() + 5;
        
        Object matrix[][] = new Object[h][l];
        
        int i = 0;
        while (itr.hasNext()) {
            No n = (No) itr.next();
            int d = this.depth(n);
            matrix[d][i] = n.getElement();
            i++;
        }
        
        String str = "";
        
        for (i = 0; i < h; i++){
            for (int j = 0; j < l; j++) {
                str += matrix[i][j] == null ? "  " : ((int) matrix[i][j] >= 0 ? " " + matrix[i][j] : matrix[i][j]);
            }
            str += "\n";
        }
        
        return str;
	}

	@Override
	public No leftChild(No no) {
		return hasLeft(no)?(no.getLeftSon()):null;
	}

	@Override
	public No rightChild(No no) {
		return hasRight(no)?(no.getRightSon()):null;
	}

	@Override
	public boolean hasLeft(No no) {
		return (no.getLeftSon() != null);
	}

	@Override
	public boolean hasRight(No no) {
		return (no.getRightSon() != null);
	}
	
	/*-------------------- methods AVL ---------------------------------------------------*/
	
	@Override
	public void insert(int item) {
		No no = new No(item);
		
		if(isEmpty()) {
			setRaiz(no);
			size++;
		}
		else {
			No aux = search(item);
			if(item < aux.getElement()) {
				aux.setLeftSon(no);
				no.setFather(aux);
				checkBalance(no);
				size++;
			}
			else {
				aux.setRightSon(no);
				no.setFather(aux);
				checkBalance(no);
				size++;
			}
		}

	}
	
	private void calcFB(No no) {
		no.setFb(height(no.getLeftSon()) - height(no.getRightSon()));
	}
	
	public void checkBalance(No current) {
		calcFB(current);
		int balance = current.getFb();

		if (balance == 2) {

			if (current.getLeftSon().getFb() >= 0) {
				current = rightRotation(current);

			} else {
				current = doubleRotationLeftRight(current);
			}

		} else if (balance == -2) {

			if (current.getRightSon().getFb() <= 0) {
				current = leftRotation(current);

			} else {
				current = doubleRotationRightLeft(current);
			}
		}

		if (current.getFather() != null) {
			checkBalance(current.getFather());
		} else {
			this.raiz = current;
		}
	}
	
	public No leftRotation(No initial) {

		No right = initial.getRightSon();
		right.setFather(initial.getFather());

		initial.setRightSon(right.getLeftSon());

		if (initial.getRightSon() != null) {
			initial.getRightSon().setFather(initial);
		}

		right.setLeftSon(initial);
		initial.setFather(right);

		if (right.getFather() != null) {

			if (right.getFather().getRightSon() == initial) {
				right.getFather().setRightSon(right);
			
			} else if (right.getFather().getLeftSon() == initial) {
				right.getFather().setLeftSon(right);
			}
		}

		calcFB(initial);
		calcFB(right);

		return right;
	}

	public No rightRotation(No initial) {

		No left = initial.getLeftSon();
		left.setFather(initial.getFather());

		initial.setLeftSon(left.getRightSon());

		if (initial.getLeftSon() != null) {
			initial.getLeftSon().setFather(initial);
		}

		left.setRightSon(initial);
		initial.setFather(left);

		if (left.getFather() != null) {

			if (left.getFather().getRightSon() == initial) {
				left.getFather().setRightSon(left);
			
			} else if (left.getFather().getLeftSon() == initial) {
				left.getFather().setLeftSon(left);
			}
		}

		calcFB(initial);
		calcFB(left);

		return left;
	}

	public No doubleRotationLeftRight(No initial) {
		initial.setLeftSon(leftRotation(initial.getLeftSon()));
		return rightRotation(initial);
	}

	public No doubleRotationRightLeft(No initial) {
		initial.setRightSon(rightRotation(initial.getRightSon()));
		return leftRotation(initial);
	}
	
	public void remove(int element) {
		removeAVL(this.raiz, element);
	}

	public void removeAVL(No current, int element) {
		if (current == null) {
			return;

		} else {

			if (current.getElement() > element) {
				removeAVL(current.getLeftSon(), element);

			} else if (current.getElement() < element) {
				removeAVL(current.getRightSon(), element);

			} else if (current.getElement() == element) {
				removeNodeFound(current);
			}
		}
	}

	public void removeNodeFound(No no) {
		No r;

		if (no.getLeftSon() == null || no.getRightSon() == null) {

			if (no.getFather() == null) {
				this.raiz = null;
				no = null;
				return;
			}
			r = no;

		} else {
			r = sucessor(no);
			no.setElement(r.getElement());
		}

		No p;
		if (r.getLeftSon() != null) {
			p = r.getLeftSon();
		} else {
			p = r.getRightSon();
		}

		if (p != null) {
			p.setFather(r.getFather());
		}

		if (r.getFather() == null) {
			this.raiz = p;
		} else {
			if (r == r.getFather().getLeftSon()) {
				r.getFather().setLeftSon(p);
			} else {
				r.getFather().setRightSon(p);
			}
			checkBalance(r.getFather());
		}
		r = null;
	}
	
	public No sucessor(No q) {
		if (q.getRightSon() != null) {
			No r = q.getRightSon();
			while (r.getLeftSon() != null) {
				r = r.getLeftSon();
			}
			return r;
		} else {
			No p = q.getFather();
			while (p != null && q == p.getRightSon()) {
				q = p;
				p = q.getFather();
			}
			return p;
		}
	}

}
