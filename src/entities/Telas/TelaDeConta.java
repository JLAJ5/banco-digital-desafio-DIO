package entities.Telas;

import entities.Cliente;
import entities.Conta;
import entities.ContaFactory;
import entities.Exceptions.CancelarAcaoException;
import entities.Exceptions.DomainException;

import java.util.List;
import java.util.Scanner;

public class TelaDeConta extends Tela {

	private List<Cliente> clientes;
	private List<Conta> contas;

	public TelaDeConta(List<Cliente> clientes, List<Conta> contas, Scanner sc) {
		super(sc);
		this.clientes = clientes;
		this.contas = contas;
	}

    private void imprimirCabecalho() {
        super.imprimirCabecalho("Você está na etapa de criação de contas.");
    }

    @Override
    public void obterDados() {
		this.imprimirCabecalho();
        ContaFactory cf = new ContaFactory();

		try {
			char cadastrarOutraConta = 'S';
			while(cadastrarOutraConta == 'S') {
				String inputUsuario = "";
	
				System.out.print("Qual o ID do cliente? ");
				inputUsuario = sc.nextLine();
				this.throwSeCancelou(inputUsuario);

				int idUsuario = Integer.parseInt(inputUsuario);
				Cliente cliente = this.clientes.stream().filter(x -> x.getId() == idUsuario).findFirst().orElse(null);

				if(cliente == null) {
					this.imprimirCabecalho();
					System.out.println("O cliente não foi encontrado.\n\n");
					continue;
				}

				try {
					System.out.print("Qual o tipo de conta (Corrente/Poupanca)? ");
					inputUsuario = sc.nextLine();
					this.throwSeCancelou(inputUsuario);

					Conta novaConta = cf.getInstance(inputUsuario, cliente);
					this.contas.add(novaConta);
					System.out.println("Dados da nova conta: " + novaConta);
				}
				catch (DomainException e) {
					this.imprimirCabecalho();
					System.out.println("***Ocorreu um erro durante a operação: " + e.getMessage() + "\n\n");
					continue;
				}

				System.out.print("\n\nDeseja abrir outra conta (S/N)? ");
				cadastrarOutraConta = sc.nextLine().charAt(0);

				if(cadastrarOutraConta == 'S') {
					this.imprimirCabecalho();
				}
			}
		}
		catch(CancelarAcaoException e) { }
    }
    
}