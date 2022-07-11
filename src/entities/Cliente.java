package entities;

public class Cliente {

	private static int contatorDeID = 1;

	private Number id;
	private String nome;

	public Cliente() {
		this.id = Cliente.contatorDeID;
		Cliente.contatorDeID++;
	}

	public Cliente(String nome) {
		this();
		this.nome = nome;
	}

	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + "]";
	}	

}
