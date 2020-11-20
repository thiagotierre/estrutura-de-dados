package ListaSE;

public class ListaSE {
	private No inicio = null, fim = null;
	private int size = 0;
	
	public void addInicio(Object o) {
		No novo = new No(o);
		if(inicio == null)
			inicio = novo;
			fim = novo;
			
		novo.setProximo(inicio);
		//novo -> inicio
		
		inicio = novo;
		//inicio -> prox -> prox -> fim
		size++;
	}
	
	public Object remInicio() {
		if(isEmpty()) return null;
		No aux = inicio; 
		inicio = aux.getProximo(); //inicio = proximo
		
		aux.setProximo(null); //anterior -> null[retirando a referencia]
		size--;
		return aux.getElemento();
	}
	
	public void addFim(Object o) {
		No novo = new No(o);
		if(inicio == null)
			inicio = novo;
			fim = novo;
			
		fim.setProximo(novo);
		fim = novo; 
		size++;
	}
	
	public Object remFim() {
		if(isEmpty()) return null;
		
		No aux = inicio; 
		while(aux != null) {
			if(aux.getProximo().getProximo() == null) {
				No aux2 = fim;
				fim = aux;
				fim.setProximo(null);// cortando a referencia com o ultimo no
				return aux2;
			}
		} 
		
		aux = aux.getProximo();
		size--;
		
		return null;
	}

	private boolean isEmpty() {
		return inicio == null;
	}
}
