package classe;

public class DataTeste {

	public static void main(String[] args) {

		Data data1 = new Data();
		data1.dia = 1;
		data1.mes = 2;
		data1.ano = 2023;

		Data data2 = new Data();
		data2.dia = 15;
		data2.mes = 9;
		data2.ano = 1986;

		System.out.printf("Primeira data %d/%d/%d", data1.dia, data1.mes, data1.ano);
		System.out.printf("\nSegunda data %d/%d/%d\n", data2.dia, data2.mes, data2.ano);

		// Resolução
		Data d1 = new Data();
//		d1.dia = 7;
//		d1.mes = 11;
//		d1.ano = 2021;

		var d2 = new Data();
		d2.dia = 31;
		d2.mes = 12;
		d2.ano = 2020;

		Data d3 = new Data(29, 1, 2005);

//		System.out.printf("%d/%d/%d\n", d1.dia, d1.mes, d1.ano);
//		System.out.printf("%d/%d/%d", d2.dia, d2.mes, d2.ano);

		System.out.println();

		System.out.println(d1.obterDataFormatada());
		System.out.println(d2.obterDataFormatada());
		System.out.println(d3.obterDataFormatada());
	}

}
