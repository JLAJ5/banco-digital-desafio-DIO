package entities.Telas;

import entities.Cliente;
import entities.Conta;
import entities.Exceptions.CancelarAcaoException;

import java.util.List;
import java.util.Scanner;

public class TelaOpcoes extends Tela {

	private List<Cliente> clientes;
	private List<Conta> contas;

	public TelaOpcoes(List<Cliente> clientes, List<Conta> contas, Scanner sc) {
		super(sc);
		this.clientes = clientes;
		this.contas = contas;
	}

    private void imprimirCabecalho() {
        super.imprimirCabecalho("Boas-vindas ao seu banco digital!\nEscolha uma das opções abaixo para começar o atendimento:\n\n");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Criar conta");
        System.out.println("4 - Listar contas");
        System.out.println("5 - Depositar");
        System.out.println("6 - Sacar");
        System.out.println("7 - Transferir");
        System.out.println("--------------------");
        System.out.println("0 - Sair\n\n");
    }

    @Override
    public void imprimirTela() {
        
        try {
            while(true) {
                this.imprimirCabecalho();

                switch(Byte.parseByte(this.sc.nextLine())) {
                    case 0: 
                        throw new CancelarAcaoException();
                    case 1:
                        new TelaDeCliente(this.clientes, this.sc).imprimirTela();
                        break;
                    case 2:
                        new TelaDeListagemDeClientes(this.clientes, this.sc).imprimirTela();;
                        break;
                    case 3:
                        new TelaDeConta(this.clientes, this.contas, this.sc).imprimirTela();
                        break;
                    case 4:
                        new TelaDeListagemDeContas(this.contas, this.sc).imprimirTela();;
                        break;
                    case 5:
                        new TelaDeDeposito(this.contas, this.sc).imprimirTela();
                        break;
                    case 6:
                        new TelaDeSaque(this.contas, this.sc).imprimirTela();
                        break;
                }
            }
        }
		catch(CancelarAcaoException e) {
            this.limparConsole();
            System.out.println("Obrigado pela preferência! Volte-sempre!");
        }
    }
    
}