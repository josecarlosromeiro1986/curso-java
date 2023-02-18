package fundamentos;

public class ConversaoTipoPrimitovoNumerico {

	public static void main(String[] args) {

		double a = 1; // implícita
		System.out.println(a);

		float b = (float) 1.12345888888888888888888; // explícita (CAST)
		System.out.println(b);

		int c = 130;
		byte d = (byte) c;
		System.out.println(d); // explícita (CAST)
		
		double e = 1.99999;
		int f = (int) e;
		System.out.println(f);
	}
}
