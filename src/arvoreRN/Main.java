package arvoreRN;

public class Main {

	public static void main(String[] args) {
		ArvoreAVL a = new ArvoreAVL();
		
		a.insert(50);
		a.insert(90);
		a.insert(20);
		a.insert(40);
		a.insert(30);
		a.insert(10);
		a.insert(45);
		a.insert(12);
		a.insert(5);
		a.show();
		System.out.println("------------------------------------------");
		a.remove(20);
		
		a.show();

	}

}
