package vetor;

public class Teste {

	public static void main(String[] args) {
		Vetor v  = new Vetor(1);
		
		v.insertAt("B");
		v.insertAt("C");
		v.insertAt("D");
		v.insertAt("F");
		v.insertAt("G");
		System.out.println(v);
		v.insertAtRank(0, "A");
		System.out.println(v);
		v.insertAtRank(0, "J");
		System.out.println(v);
		v.removeAtRank(0);
		System.out.println(v);

	}

}
