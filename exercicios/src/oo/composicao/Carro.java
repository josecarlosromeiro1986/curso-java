package oo.composicao;

public class Carro {

	final Motor motor;

	Carro() {
		this.motor = new Motor(this);
	}

	void acelerar() {
		if (this.motor.fatorInjecao < 2.6) {
			this.motor.fatorInjecao += 0.4;
		}
	}

	void frear() {
		if (this.motor.fatorInjecao > 0.5) {
			this.motor.fatorInjecao -= 0.4;
		}
	}

	void ligar() {
		this.motor.ligado = true;
	}

	void desligar() {
		this.motor.fatorInjecao = 0;
		this.motor.ligado = false;
	}

	boolean estaLigado() {
		return this.motor.ligado;
	}
}
