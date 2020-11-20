package filaComListaSE;

public class FilaListaSETeste {

	public static void main(String[] args) throws EFilaVazia {
		FilaListaSE f = new FilaListaSE();
		f.enqueue(1);
		f.enqueue(2);
		f.enqueue(3);
		System.out.println(f.toString());
		f.dequeue();
		System.out.println(f.toString());

	}

}
