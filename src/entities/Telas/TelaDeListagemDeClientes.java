package entities.Telas;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;

public class TelaDeListagemDeClientes extends Tela {

	private List<Cliente> clientes;

	public TelaDeListagemDeClientes(List<Cliente> clientes, Scanner sc) {
		super(sc);
		this.clientes = clientes;
	}

    private void imprimirCabecalho() {
        super.imprimirCabecalho("Você está na tela de listagem de clientes.\nPara sair, pressione \"Enter\".\n\n");
    }

    public void imprimirTela() {
		this.imprimirCabecalho();

		for(Cliente c : this.clientes) {
			System.out.println(c);
		}
		
        sc.nextLine();
    }
    
}