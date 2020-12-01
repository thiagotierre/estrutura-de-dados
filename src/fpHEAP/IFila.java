package fpHEAP;

public interface IFila {
	
//	public void insert(Item item);
	public void insert(int item);
	public int removeMin();
	public Object min();
	public long size();
	public boolean isEmpty();

}
