package pilha;

public interface Pilha {
	public int size();
	public boolean isEmpty();
	public Object top();
	public void push(Object o) throws Exception;
	public Object pop() throws Exception;

}
