package fila;

public interface IFila {
	public int tamanho();
	public boolean estaVazia();
	public Object inicio()
	throws EFilaVazia;
	public void enfileirar(Object o);
	public Object desenfileirar()
	throws EFilaVazia;
}
