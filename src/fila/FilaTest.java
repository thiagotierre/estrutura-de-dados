package fila;

import java.util.Scanner;

public class FilaTest {

	public static void main(String[] args) throws EFilaVazia {
		fila();

	}
	
	public static void fila() throws EFilaVazia { 
		int n = 1;
		FilaComArrays f = new FilaComArrays(1);
		while(n>0) {
			System.out.println("Digite a operação desejada:");
			System.out.println("----------------------------");
			System.out.println("1 para verificar se a fila esta vazia:");
			System.out.println("2 para verificar o tamanho da fila:");
			System.out.println("3 para verificar o valor do Topo da fila:");
			System.out.println("4 para empilhar um novo objeto na fila:");
			System.out.println("5 para deseampilhar:");
			System.out.println("6 para imprimir pilha:");
			System.out.println("0 para sair:");
			n = new Scanner(System.in).nextInt();
			switch (n) {
			case 1:
				System.out.println(f.estaVazia());
				break;
			case 2:
				System.out.println(f.tamanho());
				break;
			case 3:
				System.out.println(f.inicio());
				break;
			case 4:
				System.out.println("Digite o valor a ser empilhado");
				int elem = new Scanner(System.in).nextInt();
				Object temp = elem;
				f.enfileirar(temp);
				break;
			case 5:
				f.desenfileirar();
				break;
			case 6:
				System.out.println(f.toString());
				break;
			default:
				break;
			}
		}
	}

}
