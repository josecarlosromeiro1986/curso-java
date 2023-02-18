package controle.exerciciosEstruturasDeControle;

import java.util.Scanner;

public class imprimePalavraLetraPorLetra {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Informe a palavra que deseja ser imprimida: ");
		String palavra = entrada.next();

		for (int i = 0; i < palavra.length(); i++) {

			System.out.println(palavra.charAt(i));
		}

		System.out.println("Fim!");

		entrada.close();

		// Resolução
//		Scanner scanner = new Scanner(System.in);
//
//		System.out.println("Digite a palavra: ");
//		String palavra = scanner.nextLine();
//
//		char letras[] = palavra.toCharArray();
//
//		for (int i = 0; i < letras.length; i++) {
//			System.out.println(letras[i]);
//		}
//
//		scanner.close();
	}
}
