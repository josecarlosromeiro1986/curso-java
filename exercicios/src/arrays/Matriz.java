package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Matriz {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.print("Informe a quantidade de Alunos: ");
		int qtdAlunos = entrada.nextInt();

		System.out.print("\nInforme a quantidade de notas: ");
		int qtdNotas = entrada.nextInt();

		double[][] matriz = new double[qtdAlunos][qtdNotas];
		double totalNotas = 0;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.printf("\nInforme a %dº nota do %dº aluno:", j + 1, i + 1);
				matriz[i][j] = entrada.nextDouble();
				totalNotas += matriz[i][j];
			}
		}

		double media = totalNotas / (qtdAlunos * qtdNotas);
		System.out.printf("\nA média da turma é: %.2f\n", media);

		for (double[] notas : matriz) {
			System.out.println(Arrays.toString(notas));
		}

		entrada.close();
	}
}
