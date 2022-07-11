package entities;

public class Cliente {

	private static int contatorDeID = 1;

	private Integer id;
	private String nome;

	public Cliente() {
		this.id = Cliente.contatorDeID;
		Cliente.contatorDeID++;
	}

	public Cliente(String nome) {
		this();
		this.nome = nome;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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
