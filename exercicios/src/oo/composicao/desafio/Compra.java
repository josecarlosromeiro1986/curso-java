package oo.composicao.desafio;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	final List<Item> itens = new ArrayList<Item>();

	void adicionarItem(Produto produto, int quantidade) {
		this.itens.add(new Item(produto, quantidade));
	}

	double obterValorTotal() {
		double total = 0;
		for (Item item : this.itens) {
			total += (double) item.produto.preco * item.quantidade;
		}
		return total;
	}
}
