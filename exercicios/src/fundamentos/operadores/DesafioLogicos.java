package fundamentos.operadores;

public class DesafioLogicos {

	public static void main(String[] args) {

		// Trabalho na terça (V ou F)
		// Trabalho na quinta (V ou F)

		boolean trabalho1 = true;
		boolean trabalho2 = false;

		boolean tv50 = trabalho1 && trabalho2;
		boolean tv32 = trabalho1 ^ trabalho2;

		boolean sorvete = tv50 || tv32;

		boolean saldavel = !sorvete;

		boolean fome = !sorvete;

		System.out.println("Comprou TV 50\"? " + tv50);
		System.out.println("Comprou TV 32\"? " + tv32);
		System.out.println("Familha tomou sorvete? " + sorvete);
		System.out.println("Familha ficou saldavel? " + saldavel);
		System.out.println("Familha ficou com fome? " + fome);

	}
}
