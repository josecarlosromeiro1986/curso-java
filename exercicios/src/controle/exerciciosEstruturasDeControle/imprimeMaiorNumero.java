package controle.exerciciosEstruturasDeControle;

import java.util.Scanner;

public class imprimeMaiorNumero {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int valor = 0;
		int maior = 0;
		System.out.println("Informe 10 valores que retornarei o maior valor informado!");

		for (int i = 1; i <= 10; i++) {
			System.out.printf("Informe o %dº valor!\n", i);
			valor = entrada.nextInt();

			if (valor > maior) {
				maior = valor;
			}
		}

		System.out.printf("O maior valor informado é %d", maior);

		entrada.close();

		// Resolução
//		Scanner scanner = new Scanner(System.in);
//
//		int maiorValor = 0;
//		int contador = 0;
//
//		do {
//			System.out.println("\nDigite um numero: ");
//			int valor = scanner.nextInt();
//
//			if (valor > maiorValor) {
//				maiorValor = valor;
//			}
//
//			contador++;
//		} while (contador != 10);
//
//		System.out.printf("O maior valor foi: " + maiorValor);
//		scanner.close();
	}
}
