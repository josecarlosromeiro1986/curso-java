package oo.composicao.desafio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	final String nome;
	final List<Compra> compras = new ArrayList<Compra>();

	Cliente(String nome) {
		this.nome = nome;
	}

	void realizarCompra(Compra compra) {
		this.compras.add(compra);
	}

	double obterValorTotal() {
		double total = 0;
		for (Compra compra : this.compras) {
			total += compra.obterValorTotal();
		}
		return total;
	}
}
