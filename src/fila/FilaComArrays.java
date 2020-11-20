package fila;

import java.util.Arrays;

import fila.EFilaVazia;

public class FilaComArrays implements IFila{
	public Object fila[];
	public int i;
	public int f;
	public int total;
    public int tamanho;
	
	public FilaComArrays(int tam) {
		this.fila = new Object[tam];
		this.i = 0;
		this.f = 0;
		this.total = 0;
	    this.tamanho = 0 ;
	}

	@Override
	public int tamanho() {
		return estaVazia() ? 0 : (fila.length -i + f)%fila.length;
	}

	@Override
	public boolean estaVazia() {
		return total == 0;
	}

	@Override
	public Object inicio() throws EFilaVazia {
		return estaVazia() ?  new EFilaVazia("Fila vazia") : fila[i];
	}	

	@Override
	public void enfileirar(Object o) {
		if(isFull()) {
			int j;
			Object temp [] = new Object[fila.length*2];
			
			for(j=0; j< fila.length; j++) {
				temp[j] = fila[(j+i)%fila.length];
			}
			
			i = 0;
			f = j++;
			fila = temp;
		}
		fila[f] = o;
		f = (f+1)%fila.length;
		total++;
	}

	@Override
	public Object desenfileirar() throws EFilaVazia {
		Object o ;
		if(estaVazia())
			throw new EFilaVazia("Vazia");
		o = fila[i];
		i = (i+1)%fila.length;
		fila[i-1] = null;
		total --;
		return o;
	}
	
	public boolean isFull(){
        return total == fila.length;   
    }

	@Override
	public String toString() {
		return "[fila=" + Arrays.toString(fila) + "] , i=" + i + ", f=" + f;
	}
	
	

}
