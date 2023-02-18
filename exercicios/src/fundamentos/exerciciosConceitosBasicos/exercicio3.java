package fundamentos.exerciciosConceitosBasicos;

import java.util.Scanner;

public class exercicio3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Caculadora IMC!!!");

		System.out.print("Informe sua altura: ");
		double altura = Double.parseDouble(s.nextLine().replace(",", "."));

		System.out.print("\nInforme seu peso: ");
		double peso = Double.parseDouble(s.nextLine().replace(",", "."));

		double resultado = peso / (Math.pow(altura, 2));

		System.out.printf("\nSeu IMC é: %.2f", resultado);

		s.close();
	}
}
