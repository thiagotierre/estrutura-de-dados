package pilha2020;

import java.util.Arrays;

public class Pilha {
	
	private int t = -1;
	private Object pilha[];
	
	public Pilha(int tam) {
		this.pilha = new Object[tam];
	}
	
	public int size() {
		return t+1;
	}
	
	public boolean isEmpty() {
		return t==-1;
	}
	
	public Object top() {
		return pilha[t];
	}
	
	public Object pop()
	{
		if(isEmpty())
			throw new Error("Pilha vazia");
		
		Object temp = pilha[t];
		pilha[t] = null;
		t = t-1;
		return temp;
	}
	
	public void push(Object o) {
		if(t==pilha.length-1) {
			Object novaPilha[] = new Object[pilha.length*2];
			for(int i=0;i<pilha.length;i++) {
				novaPilha[i] = pilha[i];
			}
			
			pilha = novaPilha;
			
		}
		
		t=t+1;
		pilha[t]=o;
		
	}

	@Override
	public String toString() {
		return "Pilha [t=" + t + ", pilha=" + Arrays.toString(pilha) + "]";
	}

}
