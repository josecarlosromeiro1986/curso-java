package fundamentos;

import java.util.Scanner;

public class DesafioConversao {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite o primeiro salário: ");
		double salario1 = Double.parseDouble(entrada.nextLine().replace(",", "."));

		System.out.println("Digite o segundo salário: ");
		double salario2 = Double.parseDouble(entrada.nextLine().replace(",", "."));

		System.out.println("Digite o terceiro salário: ");
		double salario3 = Double.parseDouble(entrada.nextLine().replace(",", "."));

		double media = (salario1 + salario2 + salario3) / 3;
		System.out.printf("Sua média de salário é: %.2f", media);

		entrada.close();
	}
}
