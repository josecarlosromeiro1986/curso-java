package fundamentos;

import java.util.Scanner;

public class DesafioCalculadora {

	public static void main(String[] args) {
		// Ler num1
		// Ler num2
		// + - * / %

		Scanner s = new Scanner(System.in);

		System.out.println("Calculadora:");

		System.out.print("Escolha o primeiro número: ");
		double num1 = s.nextDouble();

		System.out.print("\nDigite umas das seguintes operações (+, -, /, *, %): ");
		String operacao = s.next();

		System.out.print("\nEscolha o segundo número: ");
		double num2 = s.nextInt();

		double resultado = operacao.equals("+") ? num1 + num2
				: operacao.equals("-") ? num1 - num2
						: operacao.equals("/") ? num1 / num2
								: operacao.equals("*") ? num1 * num2 : operacao.equals("%") ? num1 % num2 : 0;

		System.out.println("O resultado é :" + resultado);

		s.close();
	}
}

