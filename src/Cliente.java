
public class Cliente {
	private String cpf;
	private String nome;
	private String cidade;
	
	public Cliente(String cpf, String nome, String cidade) {
		this.cpf = cpf;
		this.nome = nome;
		this.cidade = cidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String toString() {
		return cpf+" - "+nome+" - "+cidade+"\n";
	}

}
