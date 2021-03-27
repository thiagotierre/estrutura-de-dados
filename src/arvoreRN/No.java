package arvoreRN;

public class No {
	
	private No father;
	private No leftSon;
	private No rightSon;
	private int element;
	private int fb;
	
	public No() { }
	
	public No(int element) {
		this.element = element;
		this.fb = 0;
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

	public int getFb() {
		return fb;
	}

	public void setFb(int fb) {
		this.fb = fb;
	}

	@Override
	public String toString() {
		return "No [element=" + element + ", fb=" + fb + "]";
	}
	
	

}
