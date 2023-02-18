package controle;

import java.util.Scanner;

public class DesafioWhileResolucao {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		int quantidadeDeNotas = 0;
		double nota = 0;
		double total = 0;

		while (nota != -1.0) {
			System.out.println("Informe a nota (ou -1 p/ sair): ");
			nota = entrada.nextDouble();

			if (nota >= 0 && nota <= 10) {

				total += nota;
				quantidadeDeNotas++;
			} else if (nota != -1.0) {
				System.out.println("Nota inválida!!!! ;D");
			}
		}

		// Calcular a média
		double media = total / quantidadeDeNotas;
		System.out.println("Média = " + media);

		entrada.close();
	}
}
