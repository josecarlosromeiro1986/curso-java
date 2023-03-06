package oo.heranca.desafio;

public class Carro {

	final int VELOCIDADE_MAXIMA;
	public int velocidadeAtual;
	private int delta = 5;

	protected Carro(int velocidadeMaxima) {
		this.VELOCIDADE_MAXIMA = velocidadeMaxima;
	}

	public void acelerar() {
		if (this.velocidadeAtual + getDelta() > VELOCIDADE_MAXIMA) {
			velocidadeAtual = VELOCIDADE_MAXIMA;
		} else {
			this.velocidadeAtual += getDelta();
		}
	}

	public void frear() {
		if (this.velocidadeAtual - 5 >= 0) {
			this.velocidadeAtual -= 5;
		} else if (this.velocidadeAtual != 0) {
			this.velocidadeAtual = 0;
		}
	}

	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

}
