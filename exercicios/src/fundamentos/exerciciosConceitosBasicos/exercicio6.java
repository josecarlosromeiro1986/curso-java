package fundamentos.exerciciosConceitosBasicos;

public class exercicio6 {

	public static void main(String[] args) {

		double a = 1;
		double b = 12;
		double c = -13;

		double delta = Math.pow(b, 2) - (4 * a * c);

		double x1 = ((-1 * b) + (Math.sqrt(delta))) / (2 * a);
		double x2 = ((-1 * b) - (Math.sqrt(delta))) / (2 * a);

		System.out.printf("O X1 da equação é %.2f e o X2 é %.2f.", x1, x2);
	}
}
