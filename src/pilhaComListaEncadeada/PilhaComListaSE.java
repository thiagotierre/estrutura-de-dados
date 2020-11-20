package pilhaComListaEncadeada;

public class PilhaComListaSE {
	private No inicioNo;
    private int t;
    
    public PilhaComListaSE() {
		inicioNo = null;
		t = 0; 
	}
    
    public boolean isEmpty() {
        return t == 0;
    }
    
    public int size() throws EPilhaVazia {
        if (isEmpty())
            throw new EPilhaVazia(null);
        
        return t;
    }
    
    public Object top() throws EPilhaVazia {
        if (isEmpty())
            throw new EPilhaVazia("Pilha vazia");
        
        return inicioNo.elemento;
    }
    
    public Object push(Object o){
        No atual = new No(o, inicioNo);
        inicioNo = atual;
        t++;
        
        return o;
    }
    
    public Object pop() throws EPilhaVazia {
        if (isEmpty())
            throw new EPilhaVazia("Pilha vazia");
        
        No atual = inicioNo;
        inicioNo = inicioNo.proximo;
        t--;
        
        return atual.elemento;
    }

	@Override
	public String toString() {
		return "PilhaComListaSE [inicioNo=" + inicioNo + ", t=" + t + "]";
	}
    
    

}
