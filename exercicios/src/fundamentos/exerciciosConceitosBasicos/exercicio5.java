package fundamentos.exerciciosConceitosBasicos;

import java.util.Scanner;

public class exercicio5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Calculadora área do triângulo!!!");

		System.out.print("Informe o valor da base: ");
		double base = s.nextDouble();

		System.out.print("\nInforme o valor da altura: ");
		double altura = s.nextDouble();

		double resultado = (base * altura) / 2;

		System.out.printf("\nA área deste retângulo é: %.2f.", resultado);

		s.close();
	}
}
