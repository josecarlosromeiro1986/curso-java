package oo.heranca.teste;

import oo.heranca.desafio.Carro;
import oo.heranca.desafio.Gol;
import oo.heranca.desafio.Opala;

public class CarroTeste {

	public static void main(String[] args) {

		Carro gol = new Gol();
		Opala opala = new Opala(320);

		gol.acelerar();
		opala.acelerar();

		System.out.println("A velocidade do gol é: " + gol.velocidadeAtual);
		System.out.println("A velocidade do opala é: " + opala.velocidadeAtual);

		for (int i = 3; i >= 0; i--) {
			gol.acelerar();
			opala.acelerar();
		}
		
		opala.ligarTurbo();
		opala.ligarAr();
		opala.acelerar();
		System.out.println("A velocidade do opala é: " + opala.velocidadeAtual);
		opala.desligarTurbo();
		opala.desligarAr();
		opala.acelerar();

		System.out.println("\nA velocidade do gol é: " + gol.velocidadeAtual);
		System.out.println("A velocidade do opala é: " + opala.velocidadeAtual);

		gol.frear();
		opala.frear();

		System.out.println("\nA velocidade do gol é: " + gol.velocidadeAtual);
		System.out.println("A velocidade do opala é: " + opala.velocidadeAtual);
	}
}
