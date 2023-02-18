package fundamentos.exerciciosConceitosBasicos;

import java.util.Scanner;

public class exercicio4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Calculadora cubo e quadrado!!!");

		System.out.print("Informe um valor: ");
		double valor = s.nextDouble();

		double cubo = Math.pow(valor, 3);
		double quadrado = Math.pow(valor, 2);

		System.out.printf("O valor ao cubo é %.2f e o valor ao quadrado é %.2f", cubo, quadrado);

		s.close();
	}
}
