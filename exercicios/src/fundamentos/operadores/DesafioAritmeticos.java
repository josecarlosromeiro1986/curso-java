package fundamentos.operadores;

public class DesafioAritmeticos {

	public static void main(String[] args) {

		int a = 3 * 4 - 10;
		int b = (int) Math.pow(a, 3);
		double c = Math.pow(a, 3);

		System.out.println(b);
		System.out.println(c);

		double d = Math.pow((6 * (3 + 2)), 2) / (3 * 2);
		double e = Math.pow(((1 - 5) * (2 - 7)) / 2, 2);
		double f = Math.pow(d - e, 3) / Math.pow(10, 3);

		System.out.println("O resultado é " + f);

	}
}
