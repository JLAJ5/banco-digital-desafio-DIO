package entities.Telas;

import entities.Cliente;
import entities.Exceptions.CancelarAcaoException;

import java.util.List;
import java.util.Scanner;

public class TelaDeCliente extends Tela {

	private List<Cliente> clientes;
	private Scanner sc;

	public TelaDeCliente(List<Cliente> clientes, Scanner sc) {
		super(sc);
		this.clientes = clientes;
		this.sc = sc;
	}

    private void imprimirCabecalho() {
        super.imprimirCabecalho("Você está na tela de cadastro de clientes.\nPara sair, digite \"Cancelar\" em qualquer momento.\n\n");
    }

    public void imprimirTela() {
		this.imprimirCabecalho();
		
		try {
			char cadastrarOutroCliente = 'S';
			
			while(cadastrarOutroCliente == 'S') {
				String inputUsuario = "";
	
				System.out.print("Qual o nome do novo cliente? ");
				inputUsuario = sc.nextLine();
				this.throwSeCancelou(inputUsuario);

				Cliente novoCliente = new Cliente(inputUsuario);
                this.clientes.add(novoCliente);
                System.out.println("Dados do novo cliente: " + novoCliente);
                
                System.out.print("\n\nDeseja cadastrar outro cliente (S/N)? ");
                cadastrarOutroCliente = sc.nextLine().charAt(0);

				if(cadastrarOutroCliente == 'S') {
					this.imprimirCabecalho();
				}
			}
		}
		catch(CancelarAcaoException e) { }
    }
    
}