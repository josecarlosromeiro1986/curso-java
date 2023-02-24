package oo.heranca.desafio;

public class CarroTeste {

	public static void main(String[] args) {

		Carro gol = new Gol();
		Carro opala = new Opala(320);

		gol.acelerar();
		opala.acelerar();

		System.out.println("A velocidade do gol é: " + gol.velocidadeAtual);
		System.out.println("A velocidade do opala é: " + opala.velocidadeAtual);

		for (int i = 100; i >= 0; i--) {
			gol.acelerar();
			opala.acelerar();
		}

		System.out.println("\nA velocidade do gol é: " + gol.velocidadeAtual);
		System.out.println("A velocidade do opala é: " + opala.velocidadeAtual);

		gol.frear();
		opala.frear();

		System.out.println("\nA velocidade do gol é: " + gol.velocidadeAtual);
		System.out.println("A velocidade do opala é: " + opala.velocidadeAtual);
	}
}
