package controle.exerciciosEstruturasDeControle;

import java.util.Scanner;

public class verificaBissexto {

	public static void main(String[] args) {

//		int ano = 2023;
//		boolean validar;
//		String saida;
//
//		if (ano % 4 != 0) {
//			validar = false;
//		} else if (ano % 100 != 0) {
//			validar = true;
//		} else if (ano % 400 != 0) {
//			validar = false;
//		} else {
//			validar = true;
//		}
//
//		if (validar) {
//			saida = "O ano " + ano + " é bissexto!";
//		} else {
//			saida = "o ano " + ano + " não é bissexto!";
//		}
//
//		System.out.println(saida);

		// Resolução
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o ano: ");
		int ano = scanner.nextInt();

		boolean bissexto = ano % 4 == 0 && ((ano % 100) != 0 || ano % 400 == 0);

		if (bissexto == true) {
			System.out.println(ano + " é um ano bissexto");
		} else {
			System.out.println(ano + " não é um ano bissexto");
		}
		scanner.close();
	}
}
