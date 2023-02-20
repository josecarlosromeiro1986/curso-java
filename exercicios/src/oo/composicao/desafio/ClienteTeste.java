package oo.composicao.desafio;

public class ClienteTeste {

	public static void main(String[] args) {

		Cliente cliente = new Cliente("João Paulo");

		Compra compra1 = new Compra();
		cliente.realizarCompra(compra1);
		compra1.adicionarItem(new Produto("Teclado", 123.45), 2);
		compra1.adicionarItem(new Produto("Mouse", 87.73), 5);

		Compra compra2 = new Compra();
		cliente.realizarCompra(compra2);
		compra2.adicionarItem(new Produto("Headset", 265.28), 4);
		compra2.adicionarItem(new Produto("Monitor", 1248.98), 3);

		System.out.printf("O valor total da compra é %.2f", cliente.obterValorTotal());
	}

}
