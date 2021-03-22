package arvore;

public class Main {

	public static void main(String[] args) {
		Arvore a = new Arvore();
		
		a.insert(6);
		a.insert(9);
		a.insert(3);
		a.insert(1);
		a.insert(8);
		a.insert(5);
		a.insert(4);
		a.insert(2);
		No altura = a.search(6);
		System.out.println("ALTURA"+a.height(altura));
		a.show();
		System.out.println("------------------------------------------");
		No remove = a.search(8);
		a.delete(remove);
		
		a.show();

	}

}
