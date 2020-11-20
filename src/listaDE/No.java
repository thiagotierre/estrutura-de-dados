package listaDE;

public class No {
	protected Object item;
	protected No anterior;
    protected No proximo;
    
    public No(Object item, No proximo, No anterior) {
		this.item = item;
		this.proximo = proximo;
		this.anterior = anterior;
	}
    
    public No() { }

	public No getAnterior() {
		return anterior;
	}

	public Object getItem() {
		return item;
	}

	public No getProximo() {
		return proximo;
	}

	@Override
	public String toString() {
		return "No [item=" + item + ", anterior=" + anterior + ", proximo=" + proximo + "]";
	}
}
