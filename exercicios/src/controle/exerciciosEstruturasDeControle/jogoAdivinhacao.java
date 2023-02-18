package controle.exerciciosEstruturasDeControle;

//import java.util.Random;
import java.util.Scanner;

public class jogoAdivinhacao {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int numeroAleatorio = 45;
		int valor;
		int tentativas = 10;
		boolean acertou = false;

		System.out.println("Tente adivinhar o número misterioso de 0 a 100, cuidado você tem apenas 10 tentativas");
		System.out.println("Vamos começar!");

		while (tentativas > 0) {
			System.out.print("\nInforme um número!");
			valor = entrada.nextInt();

			if (valor == numeroAleatorio) {
				acertou = true;
				break;
			}

			if (valor > numeroAleatorio) {
				System.out.printf("\nO número %d é maior que o número misterioso!", valor);
			} else {
				System.out.printf("\nO número %d é menor que o número misterioso!", valor);
			}

			tentativas--;
			System.out.printf("\nTentativas restantes: %d", tentativas);
		}

		if (acertou) {
			System.out.println("Parabéns você acertou!");
		} else {
			System.out.printf("\nInfelizmnete você não acertou, o número correto é %d!", numeroAleatorio);
		}

		entrada.close();

		// Resolução
//		Scanner scanner = new Scanner(System.in);
//		int continuar;
//		int numeroSorteado;
//		int tentativas;
//		int numero;
//
//		do {
//			System.out.println("Sorteando numero entre 0 e 100...\n");
//			Random numeroAleatorio = new Random();
//			numeroSorteado = numeroAleatorio.nextInt(101);
//
//			System.out.println("Começou o jogo! Sera que consegue me vencer?");
//			tentativas = 0;
//
//			do {
//				tentativas++;
//				System.out.printf("Tentativa %d: ", tentativas);
//				numero = scanner.nextInt();
//
//				if (numero > numeroSorteado) {
//
//					System.out.printf("\nO numero sorteado e menor que %d\n\n", numero);
//
//				} else if (numero < numeroSorteado) {
//
//					System.out.printf("\nO numero sorteado e maior que %d\n\n", numero);
//
//				} else {
//
//					System.out.printf("\nParabens! Voce acertou o numero em %d tentativas!\n\n", tentativas);
//					break;
//				}
//
//			} while (tentativas != 10);
//
//			System.out.println("Digite 0 para sair, ou qualquer outro numero para continuar: ");
//			continuar = scanner.nextInt();
//
//		} while (continuar != 0);
//
//		scanner.close();
	}
}
