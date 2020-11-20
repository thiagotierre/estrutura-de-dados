package pilhaRubro;

public interface PilhaRN {
	public int size();
	public boolean isEmpty();
	public boolean isFull();
	public Object topRubro();
	public void pushRubro(Object o) throws Exception;
	public Object popRubro() throws Exception;
	
	public Object topNegor();
	public void pushNegro(Object o) throws Exception;
	public Object popNegro() throws Exception;

}
