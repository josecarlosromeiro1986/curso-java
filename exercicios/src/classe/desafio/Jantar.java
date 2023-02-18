package classe.desafio;

public class Jantar {

	public static void main(String[] args) {
		Pessoa p = new Pessoa("José Carlos", 95.0);
		Comida c1 = new Comida("Feijão", 0.100);
		Comida c2 = new Comida("Arroz", 0.150);
		Comida c3 = new Comida("Bife", 0.300);

		System.out.printf("O %s tem %.2f quilos.", p.nome, p.peso);
		p.comer(c1);
		System.out.printf("\nO %s tem %.2f quilos.", p.nome, p.peso);
		p.comer(c2);
		System.out.printf("\nO %s tem %.2f quilos.", p.nome, p.peso);
		p.comer(c3);
		System.out.printf("\nO %s tem %.2f quilos.", p.nome, p.peso);
	}
}
