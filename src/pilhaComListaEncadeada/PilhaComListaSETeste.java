package pilhaComListaEncadeada;

public class PilhaComListaSETeste {
	
	public static void main(String[] args) throws EPilhaVazia {
		PilhaComListaSE p = new PilhaComListaSE();
		p.push(1);
		p.push(2);
		p.push(3);
		p.push(4);
		System.out.println(p.toString());
		p.pop();
		System.out.println(p.toString());
		System.out.println(p.top());
		System.out.println(p.size());
	}
	
}
