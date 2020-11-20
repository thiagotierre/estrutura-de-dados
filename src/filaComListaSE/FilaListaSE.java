package filaComListaSE;

public class FilaListaSE {
	
    private No inicioNo = null;
    private No fimNo = null;
    
    public boolean isEmpty() {
        return inicioNo == null;
    }
    
    public int size() throws EFilaVazia {
        int i = 0;
        
        if (isEmpty()) 
            throw new EFilaVazia("Fila vazia");
        
        for (No j = inicioNo; j != null; j = j.proximo) {
            i++;
        }
        
        return i;
    }
        
    public Object peek() throws EFilaVazia {
    	
        if (isEmpty())
            throw new EFilaVazia("Fila vazia"); 
        
        return inicioNo.elemento;
    }
    
    public Object enqueue(Object o) {
    	
        No atual = new No(o, null);
        
        if (isEmpty()) {
            inicioNo = atual;
        } else {
            fimNo.proximo = atual;
        }
        
        fimNo = atual;
        
        return o;
    }
    
    public Object dequeue() throws EFilaVazia {
    	
        if (isEmpty())
            throw new EFilaVazia(null);
        
        Object atual = inicioNo.elemento;
        
        if (fimNo == inicioNo)
            fimNo = null;
        
        inicioNo = inicioNo.proximo;
        
        return atual;
    }

	@Override
	public String toString() {
		return "FilaListaSE [inicio=" + inicioNo + ", fim=" + fimNo + "]";
	}
    
    
}
