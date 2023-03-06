package oo.encapsulamento;

public class Pessoa {

	private String nome;
	private int idade;
	private String sobrenome;

	Pessoa(String nome, String sobrenome, int idade) {
		setNome(nome);
		setSobrenome(sobrenome);
		setIdade(idade);
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNomeCompleto() {
		return getNome() + " " + getSobrenome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		idade = Math.abs(idade);
		if (idade <= 120) {
			this.idade = idade;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Olá eu sou o " + getNome() + " e tenho " + getIdade() + " anos.";
	}
}
