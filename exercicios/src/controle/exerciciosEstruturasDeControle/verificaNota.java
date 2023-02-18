package controle.exerciciosEstruturasDeControle;

import java.util.Scanner;

public class verificaNota {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.print("Informe a primeira nota!");
		double nota1 = entrada.nextDouble();

		System.out.print("\nInforme a segunda nota!");
		double nota2 = entrada.nextDouble();

		double media = (nota1 + nota2) / 2;

		if (media >= 7.0) {
			System.out.println("Aprovado!");
		} else if (media < 7.0 && media > 4.0) {
			System.out.println("Recuperação");
		} else {
			System.out.println("Reprovado");
		}

		entrada.close();
		
		// Resolução
		
//		Scanner scanner = new Scanner(System.in);
//
//		System.out.println("Nota Parcial 1: ");
//		double nota1 = scanner.nextDouble();
//
//		System.out.println("Nota Parcial 2: ");
//		double nota2 = scanner.nextDouble();
//
//		double media = (nota1 + nota2) / 2;
//
//		if (media >= 7) {
//			System.out.println("Sua média foi " + media + " e você está Aprovado.");
//		} else if (media >= 4) {
//			System.out.println("Sua média foi " + media + " e você está de Recuperação.");
//		} else {
//			System.out.println("Sua média foi " + media + " e você está Reprovado.");
//		}
//
//		scanner.close();
	}
}
