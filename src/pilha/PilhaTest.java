package pilha;

import java.util.Scanner;

public class PilhaTest {

	public static void main(String[] args) throws Exception {
		pilha();

	}
	
	public static void pilha() throws Exception {
		int n = 1;
		PilhaArray pilhaArray = new PilhaArray(1);
		while(n>0) {
			System.out.println("Digite a operação desejada:");
			System.out.println("----------------------------");
			System.out.println("1 para verificar se a pilha esta vazia:");
			System.out.println("2 para verificar a quantidade de elementos da pilha:");
			System.out.println("3 para verificar o valor do Topo da pilha:");
			System.out.println("4 para empilhar um novo objeto na pilha:");
			System.out.println("5 para deseampilhar:");
			System.out.println("6 para imprimir pilha:");
			System.out.println("7 para impilhar Linear:");
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
				System.out.println(pilhaArray.top());
				break;
			case 4:
				System.out.println("Digite o valor a ser empilhado");
				int elem = new Scanner(System.in).nextInt();
				Object temp = elem;
				pilhaArray.push(temp);
				break;
			case 5:
				pilhaArray.pop();
				break;
			case 6:
				System.out.println(pilhaArray.toString());
				break;
			case 7:
				System.out.println("Digite o valor a ser empilhado");
				int elemL = new Scanner(System.in).nextInt();
				Object tempL = elemL;
				pilhaArray.pushLinear(tempL);
				break;
			default:
				break;
			}
		}
	}

}
