package arvoreAVL;

public class Main {

	public static void main(String[] args) {
		ArvoreAVL a = new ArvoreAVL();
		
		a.insert(50);
		a.insert(90);
		a.insert(20);
		a.insert(40);
		a.insert(30);
		a.insert(10);
//		a.insert(4);
//		a.insert(2);
//		No altura = a.search(6);
//		System.out.println("ALTURA"+a.height(altura));
		a.show();
		System.out.println("------------------------------------------");
		No remove = a.search(10);
		a.delete(remove);
		
		a.show();

	}

}
