package pilhaRubro;

import java.util.Scanner;

public class PilhaRNTeste {

	public static void main(String[] args) throws Exception {
		pilha();

	}
	
	public static void pilha() throws Exception {
		int n = 1;
		PilhaRubro pilhaArray = new PilhaRubro(1);
		while(n>0) {
			System.out.println("Digite a operação desejada:");
			System.out.println("----------------------------");
			System.out.println("1 para verificar se a pilha esta vazia:");
			System.out.println("2 para verificar a quantidade de elementos da pilha:");
			System.out.println("3 para empilhar um novo objeto RUBRO na pilha:");
			System.out.println("4 para empilhar um novo objeto NEGRO na pilha:");
			System.out.println("5 para desempilhar RUBRO:");
			System.out.println("6 para desempilhar NEGRO:");
			System.out.println("7 Mostrar pilha:");
			System.out.println("0 para sair:");
			n = new Scanner(System.in).nextInt();
			switch (n) {
			case 1:
				System.out.println(pilhaArray.isEmpty());
				break;
			case 2:
				System.out.println(pilhaArray.size());
				break;
			case 3:
				pilhaArray.pushRubro("R");
				break;
			case 4:
				pilhaArray.pushNegro("N");
				break;
			case 5:
				pilhaArray.popRubro();
				break;
			case 6:
				pilhaArray.popNegro();
				break;
			case 7:
				System.out.println(pilhaArray.toString());
				break;
			default:
				break;
			}
		}
	}

}
