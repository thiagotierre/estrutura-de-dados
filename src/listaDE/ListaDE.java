package listaDE;

public class ListaDE {
	protected No inicio = null;
	protected No fim = null;

	public ListaDE() { }
	
	public No first() {
		return inicio;
	}
	
	public No last() {
		return fim;
	}
	
	public void insertBefore(Object o) {
		No tmp = new No();
		tmp.item = o;
		tmp.proximo = null;
		
		if(isEmpty()) {
			tmp.anterior = null;
			inicio = tmp;
		}else {
			tmp.anterior = fim;
			fim.proximo = tmp;
		}
		fim = tmp;
	}
	
	public void insertAfter(Object o) {
		No tmp = new No(o, null, fim);
		 if(inicio == null)
		    inicio = tmp;
		 else
	        fim.proximo = tmp;
		 fim = tmp;
	}

	private boolean isEmpty() {
		return inicio == null;
	}
	
	public void remove(Object o) {
		No aux, anterior, proximo;
		anterior = null; aux = inicio; proximo = aux.proximo;
		
		while(aux !=null) {
			if(aux.item == o) break;
			anterior = aux;
			aux = aux.proximo;
		}
	}
	
	public void print_first() {
		No aux = inicio;
		while (aux!=null) {
			System.out.println("["+aux.getItem()+","+aux.getProximo()+", "+aux.getAnterior()+"]");
			aux = aux.getProximo();
		}
	}

}
