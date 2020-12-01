package fpHEAP;

public class Main {

	public static void main(String[] args) {
		HeapSort h = new HeapSort(10);
		h.insert(16);
		h.insert(14);
		h.insert(10);
		h.insert(8);
		h.insert(7);
		h.insert(9);
		h.insert(3);
		h.insert(2);
		h.insert(4);
		h.print();
		System.out.println("------------------------");
		System.out.println(h.removeMin());
		System.out.println("------------------------");
		h.print();
		System.out.println("------------------------");
		System.out.println(h.min());
		System.out.println("------------------------");
		System.out.println(h.toString());

	}

}
