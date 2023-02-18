package arrays;

import java.util.Scanner;

public class DesafioArray {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.print("Informe a quantidade de notas: ");
		int qtd = entrada.nextInt();

		double[] notas = new double[qtd];

		for (int i = 0; i < qtd; i++) {
			System.out.printf("\nInforme a %dº nota: ", i + 1);
			notas[i] = entrada.nextDouble();
		}

		double totalNotas = 0;
		for (double nota : notas) {
			totalNotas += nota;
		}

		double media = totalNotas / qtd;
		System.out.printf("\nA sua média é: %.2f", media);

		entrada.close();
	}
}
