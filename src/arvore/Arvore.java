package arvore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arvore implements TADArvore {
	
	private No raiz;
	private int size;
	
	private ArrayList<No> inOrder = new ArrayList<No>();
    private ArrayList<No> preOrder = new ArrayList<No>();
    private ArrayList<No> posOrder = new ArrayList<No>();
    
    public Arvore() {
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
	public Iterator<Integer> elements() {
		List<Integer> objs = new ArrayList<Integer>();
		while(children(getRaiz()).hasNext())
			objs.add(children(getRaiz()).next().getElement());
		Iterator<Integer> ite = objs.iterator();
		return ite;
	}

	@Override
	public Iterator<No> children(No no) {
		ArrayList<No> chil = new ArrayList<No>();
		chil.add(no.getLeftSon());
		chil.add(no.getRightSon());
		return chil.iterator();
	}

	@Override
	public Iterator<No> nos() {
		return (root()==null)?null:inOrder(root());
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
				size++;
			}
			else {
				aux.setRightSon(no);
				no.setFather(aux);
				size++;
			}
		}

	}

	@Override
	public void delete(No no) {
		No aux = search(no.getElement());
		if(aux.getLeftSon()==null && aux.getRightSon()==null) {
			if(aux.getElement() < aux.getFather().getElement()) {
				aux.getFather().setLeftSon(null);
				aux.setFather(null);
			} else {
				aux.getFather().setRightSon(null);
				aux.setFather(null);
			}
		}
		
		if(aux.getLeftSon()!=null && aux.getRightSon()==null) {
			aux.getLeftSon().setFather(aux.getFather());
			aux.getFather().setLeftSon(aux.getLeftSon());
			aux.setLeftSon(null);
			aux.setFather(null);
		}
		
		if(aux.getLeftSon()==null && aux.getRightSon()!=null) {
			aux.getRightSon().setFather(aux.getFather());
			aux.getFather().setRightSon(aux.getRightSon());
			aux.setRightSon(null);
			aux.setFather(null);
		}
		
		if(aux.getLeftSon()!=null && aux.getRightSon()!=null) {
			No lastLeftSon = aux.getRightSon();
			while(lastLeftSon.getLeftSon()!=null) {
				lastLeftSon = lastLeftSon.getLeftSon();
			}
			//sucessor
			//lastLeftSon.getLeftSon();
			if(aux.getElement() < aux.getFather().getElement()) {
				lastLeftSon.setFather(aux.getFather());
				lastLeftSon.setLeftSon(aux.getLeftSon());
				lastLeftSon.setRightSon(aux.getRightSon());
				aux.getFather().setLeftSon(lastLeftSon.getLeftSon());
				aux.setLeftSon(null);
				aux.setRightSon(null);
				aux.setFather(null);
				
			} else {
				
				lastLeftSon.setFather(aux.getFather());
				lastLeftSon.setLeftSon(aux.getLeftSon());
				lastLeftSon.setRightSon(aux.getRightSon());
				aux.getFather().setRightSon(lastLeftSon.getLeftSon());
				aux.setLeftSon(null);
				aux.setRightSon(null);
				aux.setFather(null);
				
			}
			
		}

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
	
}
