package controle.exerciciosEstruturasDeControle;

import java.util.Scanner;

public class verificaNumeroPrimo {

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
		
		if (count > 2) {
			System.out.println("Não é número primo!");
		} else {
			System.out.println("É número primo!");
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
//		if (contadorDeDivisores == 0) {
//			System.out.println("\nO numero " + numero + " é primo.");
//		} else {
//			System.out.println("\nO numero " + numero + " não é primo.");
//		}
//
//		scanner.close();
	}
}
