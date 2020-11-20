package listaDE;

public class Teste {

	public static void main(String[] args) {
		ListaDE l = new ListaDE();
		l.insertBefore(1);
		l.insertBefore(2);
		l.insertBefore(3);
		l.print_first();
		l.insertAfter(4);
		l.print_first();
	}

}
