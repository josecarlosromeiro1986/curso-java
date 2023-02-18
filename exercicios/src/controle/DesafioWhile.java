package controle;
import java.util.Scanner;

public class DesafioWhile {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		double total = 0;
		double valor = 0;
		double media = 0;
		int quantidade = 0;

		while (valor != -1.0) {
			System.out.println("Digite o valor de sua nota! ");

			valor = entrada.nextDouble();

			if (valor >= 0 && valor <= 10) {

				total += valor;
				quantidade++;
			} else if (valor != -1.0) {
				System.out.println("Digite um valor válido de 0 a 10!");
			}
		}

		media = total / quantidade;

		System.out.printf("A média da turma de %d alunos é de %.2f!", quantidade, media);

		entrada.close();
	}
}
