package oo.heranca.desafio;

public class Opala extends Carro {

	Opala() {
		this(220);
	}

	Opala(int velocidadeMaxima) {
		super(velocidadeMaxima);
		this.delta = 15;
	}

//	@Override
//	void acelerar() {
//		super.acelerar();
//	}
}
