package controle;

public class DesafioFor {

	public static void main(String[] args) {
		
//		String valor = "#";
//		for (int i = 1; i <= 5; i++) {
//			System.out.println(valor);
//			valor += "#";
//		}
		
		// Versão do desafio
		// Não pode usaer valor numério para controlar o laço!
		
		String valor = "#";
		
		for (String i = "######"; !valor.equals(i);) {
			System.out.println(valor);
			valor += "#";
		}
		
		// Resolução
		for (String v = "#"; !v.equals("######"); v += "#") {
			System.out.println(v);
		}
	}
}
