package filaComListaSE;

public class No {
	public Object elemento;
	public No proximo;
	
	public No(Object e, No p) {
		this.elemento = e;
		this.proximo = p;  
	}

	@Override
	public String toString() {
		return "No -> [elemento=" + elemento + ", proximo=" + proximo + "]";
	}
	
	
	
}
