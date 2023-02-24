package oo.heranca.desafio;

public class Carro {

	final int VELOCIDADE_MAXIMA;
	int velocidadeAtual;
	int delta = 5;

	Carro(int velocidadeMaxima) {
		this.VELOCIDADE_MAXIMA = velocidadeMaxima;
	}

	void acelerar() {
		if (this.velocidadeAtual + delta > VELOCIDADE_MAXIMA) {
			velocidadeAtual = VELOCIDADE_MAXIMA;
		} else {
			this.velocidadeAtual += delta;
		}
	}

	void frear() {
		if (this.velocidadeAtual - 5 >= 0) {
			this.velocidadeAtual -= 5;
		} else if (this.velocidadeAtual != 0) {
			this.velocidadeAtual = 0;
		}
	}
}
