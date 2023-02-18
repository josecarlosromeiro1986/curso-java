package fundamentos.exerciciosConceitosBasicos;

import java.util.Scanner;

public class exercicio1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Conversor de Fahrenheit para Celsius!!!");

		System.out.print("Informa o valor: ");
		double valor = s.nextDouble();

		double resultado = (valor - 32) / 1.8;

		System.out.printf("\nO valor em °C é: %.2f", resultado);

		s.close();
	}
}
