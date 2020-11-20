package pilhaComListaEncadeada;

public class No {
	 public Object elemento;
     public No proximo;
     
     public No(Object elemento, No proximo) {
		this.elemento = elemento;
		this.proximo = proximo;
	}

	@Override
	public String toString() {
		return "No -> [elemento=" + elemento + ", proximo=" + proximo + "]";
	}

}
