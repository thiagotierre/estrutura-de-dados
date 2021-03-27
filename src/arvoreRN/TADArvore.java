package arvoreRN;

import java.util.Iterator;

public interface TADArvore {
	
	public int size();
	public int height(No no);
	public int depth(No no);
	public Iterator<No> children(No no);
	public boolean isEmpty();
	public boolean isInternal(No no);
	public boolean isExternal(No no);
	public boolean hasLeft(No no);
	public boolean hasRight(No no);
	public boolean isRoot(No no);
	public No root();
	public No parent(No no);
	public No leftChild(No no);
	public No rightChild(No no);
	public No replace(No no, int item);
	public No search(int item);
	public No treeSearch(int item, No no);
	public void insert(int item);

}
