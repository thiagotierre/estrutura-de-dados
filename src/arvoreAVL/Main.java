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
		a.show();
		System.out.println("------------------------------------------");
		No remove = a.search(10);
		a.delete(remove);
		
		a.show();

	}

}
