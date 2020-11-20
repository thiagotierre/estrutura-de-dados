package pilha;

import java.util.Arrays;

public class PilhaArray implements Pilha{

	private Object S[];
	private int t =-1;
	private final int c = 10;
	
	public PilhaArray(int tam) {
		this.S = new Object [tam];
	}
	
	@Override
	public int size() {
		return t+1 ;
	}

	@Override
	public boolean isEmpty() {
		return t==-1 ? true : false;
	}

	@Override
	public Object top() {
		return S[t];
	}

	@Override
	public void push(Object o) throws Exception {
		if(t==S.length-1) {
			Object temp [] = new Object[S.length*2];
			for (int i=0; i<S.length;i++) {
				temp[i] = S[i];
				
			}
			S = temp;
		}
			
		
		t = t+1;
		S[t] = o;
	}
	
	public void pushLinear(Object o) throws Exception {
		if(t==S.length-1) {
			Object temp [] = new Object[S.length+c];
			for (int i=0; i<S.length;i++) {
				temp[i] = S[i];
				
			}
			S = temp;
		}
		
		t = t+1;
		S[t] = o;
	}

	@Override
	public Object pop() throws Exception {
		if(isEmpty())
			throw new Exception("Pilha vazia");
		
		Object temp = S[t];
		S[t] = null;
		t = t-1;
		return temp;
		
	}

	@Override
	public String toString() {
		return "PilhaArray [S=" + Arrays.toString(S) + ", t=" + t + "]";
	}

	
}
