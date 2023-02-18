package controle.exerciciosEstruturasDeControle;

import java.util.Scanner;

public class verificaNumeroPrimoSwitch {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe o número: ");
		int valor = entrada.nextInt();
		int count = 1;

		for (int i = 2; i <= valor; i++) {
			if (valor % i == 0) {
				count++;
			}
		}

		switch (count) {
		case 2:
			System.out.println("É número primo!");
			break;

		default:
			System.out.println("Não é número primo!");
			break;
		}

		entrada.close();

		// Resolução
//		int contadorDeDivisores = 0;
//		Scanner scanner = new Scanner(System.in);
//
//		System.out.println("\nDigite um numero para verificar se é primo:");
//		int numero = scanner.nextInt();
//
//		for (int i = 2; i < numero; i++) {
//			if (numero % i == 0) {
//				contadorDeDivisores++;
//			}
//		}
//
//		switch (contadorDeDivisores) {
//
//		case 0:
//			System.out.println("O numero " + numero + " é um numero primo.");
//			break;
//
//		default:
//			System.out.println("O numero " + numero + "  não é um numero primo.");
//
//		}
//
//		scanner.close();
	}
}
