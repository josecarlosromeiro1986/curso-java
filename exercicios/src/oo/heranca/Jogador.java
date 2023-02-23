package oo.heranca;

public class Jogador {

	int vida = 100;
	int x;
	int y;

	boolean atacar(Jogador oponente) {
		int deltaX = Math.abs(this.x - oponente.x);
		int deltaY = Math.abs(this.y - oponente.y);

		if (deltaX == 0 && deltaY == 1) {
			oponente.vida -= 10;
			return true;
		} else if (deltaX == 1 && deltaY == 0) {
			oponente.vida -= 10;
			return true;
		} else {
			return false;
		}

	}

	boolean andar(Direcao direcao) {
		switch (direcao) {
		case NORTE:
			y--;
			break;

		case LESTE:
			x++;
			break;

		case OESTE:
			x--;
			break;

		case SUL:
			y++;
			break;
		}

		return true;
	}
}
