package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioFilter {

	public static void main(String[] args) {

		Gamer g1 = new Gamer(1250, "Bola8", 103);
		Gamer g2 = new Gamer(980, "Monhun", 98);
		Gamer g3 = new Gamer(1050, "Alfa", 30);
		Gamer g4 = new Gamer(300, "Maluko", 750);
		Gamer g5 = new Gamer(789, "SlkMon", 215);
		Gamer g6 = new Gamer(1900, "ProJ1", 25);

		List<Gamer> gamers = Arrays.asList(g1, g2, g3, g4, g5, g6);

		Predicate<Gamer> ligaOuro = g -> g.pontos >= 1000;
		Predicate<Gamer> ligaPrata = g -> g.pontos < 1000 && g.pontos >= 500;
		Predicate<Gamer> ligaBronze = g -> g.pontos < 500;
		Predicate<Gamer> maisDeCemJogos = g -> g.qtdPartidas > 100;
		Function<Gamer, String> printGamer = g -> g.nick + " com " + g.pontos + " pontos e com " + g.qtdPartidas + " jogos!";

		System.out.println("#Jogadores da liga ouro!");
		gamers.stream()
			.filter(ligaOuro)
			.map(printGamer)
			.forEach(System.out::println);

		System.out.println("\n#Jogadores da liga ouro com mais de 100 jogos!");
		gamers.stream()
			.filter(ligaOuro)
			.filter(maisDeCemJogos)
			.map(printGamer)
			.forEach(System.out::println);

		System.out.println("\n#Jogadores da liga prata!");
		gamers.stream()
			.filter(ligaPrata)
			.map(printGamer)
			.forEach(System.out::println);

		System.out.println("\n#Jogadores da liga bronze!");
		gamers.stream()
			.filter(ligaBronze)
			.map(printGamer)
			.forEach(System.out::println);
	}
}
