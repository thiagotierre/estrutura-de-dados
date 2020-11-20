package vetor;

import java.util.Arrays;

public class Vetor {
	private Object[] elementos; 
	private int size;
	
	public Vetor(int capacidade){
		this.elementos = new Object[capacidade];
		this.size = 0;
	}
	
	//adiciona de forma sequencial
	public void insertAt(Object elemento) {
		this.dobrarTamanho();
		if(this.size < this.elementos.length)
			this.elementos[this.size] = elemento;
			this.size++;
	}
	
	public void insertAtRank(int posicao, Object elemento) {
		//verifica se posição passada como atributo e valida
		if (!(posicao >= 0 && posicao < size)){
			throw new IllegalArgumentException("Posição inválida");
		} 
		
		this.dobrarTamanho();
		//move os elementos do vetor
		for(int i=size-1; i >= posicao; i--) {
			this.elementos[i+1]=this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.size++;
		
	}
	
	public Object elemAtRank(int posicao) {
		return this.elementos[posicao];
	}
	
	public Object replaceAtRank(int posicao, Object o) {
		Object aux = this.elemAtRank(posicao);
		this.elementos[posicao] = o;
		return aux;
	}
	
	public Object removeAtRank(int posicao) {
		//verifica se posição passada como atributo e valida
		if (!(posicao >= 0 && posicao < size)){
			throw new IllegalArgumentException("Posição inválida");
		} 
		
		Object aux = this.elementos[posicao];
		for(int i = posicao; i < size-1; i++) {
			this.elementos[i] = this.elementos[i+1];
		}
		this.size--;
		return aux;
	}
	
	private void dobrarTamanho() {
		if(this.size == this.elementos.length) {
			Object[] aux = new Object[this.elementos.length*2];
			for(int i=0; i < this.elementos.length; i++) {
				aux[i]=this.elementos[i];
			}
			this.elementos = aux;
		}
	}
	
	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		return Arrays.toString(elementos) + ", size=" + size;
	}
	
}
