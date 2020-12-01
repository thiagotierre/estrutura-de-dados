package pilha2020;

import java.util.Scanner;

public class Pilha2020TESTE {

	public static void main(String[] args) throws Exception {
		pilha2();

	}
	
	public static void pilha() throws Exception {
		int n = 1;
		Pilha pilhaArray = new Pilha(1);
		while(n>0) {
			System.out.println("Digite a operação desejada:");
			System.out.println("----------------------------");
			System.out.println("1 para verificar se a pilha esta vazia:");
			System.out.println("2 para verificar a quantidade de elementos da pilha:");
			System.out.println("3 para verificar o valor do Topo da pilha:");
			System.out.println("4 para empilhar um novo objeto na pilha:");
			System.out.println("5 para deseampilhar:");
			System.out.println("6 para imprimir pilha:");
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
				System.out.println(pilhaArray.pop());
				break;
			case 6:
				System.out.println(pilhaArray.toString());
				break;
			default:
				break;
			}
		}
	}
	
	public static void pilha2() throws Exception {
		PilhaRN p = new PilhaRN(1);
        
        p.pushR();
        p.pushR();
        p.pushN();
        p.pushN();
        p.pushN();
        p.pushR();
        p.pushN();
        p.pushN();
        p.pushN();
        
        System.out.println(p);
	}

}
