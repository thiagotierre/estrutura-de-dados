package arvore;

public class No {
	private int element;
	private No father;
	private No leftSon;
	private No rightSon;
	
	public No() { }
	
	public No(int element) {
		this.element = element;
	}

	public int getElement() {
		return element;
	}
	public void setElement(int element) {
		this.element = element;
	}
	public No getFather() {
		return father;
	}
	public void setFather(No father) {
		this.father = father;
	}
	public No getLeftSon() {
		return leftSon;
	}
	public void setLeftSon(No leftSon) {
		this.leftSon = leftSon;
	}
	public No getRightSon() {
		return rightSon;
	}
	public void setRightSon(No rightSon) {
		this.rightSon = rightSon;
	}

	@Override
	public String toString() {
		return "[element=" + element + "]";
	}
	
	

}
