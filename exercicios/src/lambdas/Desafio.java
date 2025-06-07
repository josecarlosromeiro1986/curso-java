package lambdas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.of("pt", "BR"));

		Produto p = new Produto("iPad", 3235.89, 0.13);
		
		Function<Produto, Double> precoReal = prod -> prod.preco * (1 - prod.desconto);
		UnaryOperator<Double> calcularImposto = valor -> valor >= 2500 ? (valor * (8.5 / 100)) + valor : valor;
		UnaryOperator<Double> calcularFrete = valor -> valor >= 3000 ? valor + 100 : valor + 50;
		UnaryOperator<Double> arredondar = valor -> {
			BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_EVEN);
			return bd.doubleValue();
		};
		Consumer<Double> formatar = valor -> System.out.printf("R$ %.2f%n", valor);

		Double resultado = precoReal
			    .andThen(calcularImposto)
			    .andThen(calcularFrete)
			    .andThen(arredondar)
			    .apply(p);

		formatar.accept(resultado);
		
		/*
		 * 1. A partir do produto Calcular o preço real (com desconto)
		 * 2. Imposto Municipal: >= 2500 (8,5%)/ < 2500 (Isento)
		 * 3. Frete: >= 3000 (100)/ < 3000 (50)
		 * 4. Arredondar: Deixar com duas casas decimais
		 * 5. Formatar: R$1234,56
		 */
		
	}
}
