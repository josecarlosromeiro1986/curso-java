package classe;

public class Usuario {
	String nome;
	String email;

	public boolean equals(Object objeto) {

		if (objeto instanceof Usuario) {
			Usuario outro = (Usuario) objeto;

			boolean nomeIqual = outro.nome.equals(this.nome);
			boolean emailIqual = outro.email.equals(this.email);

			return nomeIqual && emailIqual;
		} else {
			return false;
		}
	}
}
