package controle.exerciciosEstruturasDeControle;

import java.util.Scanner;

public class numerosPositivos {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int valor = 0;
		int soma = 0;

		System.out.println(
				"Informe os valores para realizarmos a soma, caso o valor seja negativo finalizamos a execução.");

		do {
			System.out.println("Informe o valor!");
			valor = entrada.nextInt();

			if (valor < 0) {
				break;
			}

			soma += valor;

			System.out.printf("A soma é %d \n", soma);
		} while (valor >= 0);

		System.out.println("Fim!");
		entrada.close();

		// Resolução
//		Scanner scanner = new Scanner(System.in);
//
//		int somadorDeNumeros = 0;
//		int numero = 0;
//
//		while (numero >= 0) {
//			System.out.println("Digite um numero inteiro (ou negativo para sair): ");
//			numero = scanner.nextInt();
//			if (numero >= 0) {
//				somadorDeNumeros += numero; // Isso é igual a somadorDeNumeros = somadorDeNumeros + numero;
//				System.out.printf("\nSoma até o momento: %d\n", somadorDeNumeros);
//			}
//		}
//		scanner.close();
	}
}
