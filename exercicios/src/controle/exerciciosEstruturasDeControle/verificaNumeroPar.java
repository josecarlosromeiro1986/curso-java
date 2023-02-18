package controle.exerciciosEstruturasDeControle;

import java.util.Scanner;

public class verificaNumeroPar {

	public static void main(String[] args) {

//		Scanner entrada = new Scanner(System.in);
//
//		System.out.println("Vamos verificar se seu número é par e está ente 0 e 10");
//		System.out.print("Inform um número: ");
//		double valor = entrada.nextDouble();
//		String saida;
//
//		if (valor >= 0 && valor <= 10 && valor % 2 == 0) {
//			saida = "O número " + valor + " está entre 0 e 10 e é Par!";
//		} else {
//
//			saida = "O número " + valor + " não está entre 0 e 10 e ";
//
//			if (valor % 2 == 0) {
//				saida += "é Par!";
//			} else {
//				saida += "não é Par!";
//			}
//		}
//
//		System.out.println(saida);
//		entrada.close();

		// Resolução
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite um numero: ");
		int numero = scanner.nextInt();

		if (numero >= 0 && numero <= 10) {
			if (numero % 2 == 0) {
				System.out.println("O numero " + numero + " está entre 0 e 10 e é um par.");
			} else {
				System.out.println("O numero " + numero + " está entre 0 e 10 mas não é um par.");
			}
		} else {
			System.out.println("O numero " + numero + " não está entre 0 e 10.");
		}
		scanner.close();
	}
}
