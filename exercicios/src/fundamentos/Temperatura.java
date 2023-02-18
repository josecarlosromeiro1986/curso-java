package fundamentos;

public class Temperatura {

	public static void main(String[] args) {
		//(F - 32) x 5/9 = C
		double tempF = 86;
		final double DIF = 32;
		final double MULT = 5.0 / 9.0;
		double tempC;
		
		tempC = (tempF - DIF) * MULT;
		System.out.println("Temperatura: " + tempC + "°C"); // ALT + 0176
		
		tempF = 150;
		tempC = (tempF - DIF) * MULT;
		System.out.println("Temperatura: " + tempC + "°C"); // ALT + 0176
	}

}
