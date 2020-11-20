package ListaSE;

public class No {
	public Object elemento;
    public No proximo;
    
    public No(Object elemento) {
		this.elemento = elemento;
		this.proximo = null;
	}
    
	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	@Override
	public String toString() {
		return "No -> [elemento=" + elemento + ", proximo=" + proximo + "]";
	}
}
