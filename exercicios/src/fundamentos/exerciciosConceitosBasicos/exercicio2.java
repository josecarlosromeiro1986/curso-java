package fundamentos.exerciciosConceitosBasicos;

import java.util.Scanner;

public class exercicio2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Conversor de Celsius para Fahrenheit!!!");

		System.out.print("Informa o valor: ");
		double valor = s.nextDouble();

		double resultado = (valor * 1.8) + 32;

		System.out.printf("\nO valor em °F é: %.2f", resultado);

		s.close();
	}
}
