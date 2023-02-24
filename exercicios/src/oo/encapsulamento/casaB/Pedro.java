package oo.encapsulamento.casaB;

import oo.encapsulamento.casaA.Ana;

public class Pedro extends Ana {

	void testeAcesso() {
		System.out.println(new Ana().todosSabem);
		System.out.println(todosSabem);
//		System.out.println(facoDentroDeCasa);
		System.out.println(formaDeFalar);
//		System.out.println(segredo);
	}
}
