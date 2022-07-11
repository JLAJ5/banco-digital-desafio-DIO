import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;
import entities.Exceptions.DomainException;

public class Main {

	private static List<Cliente> clientes = new ArrayList<>();

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		try {
			cc.depositar(100);
			cc.transferir(100, poupanca);
			
			cc.imprimirExtrato();
			poupanca.imprimirExtrato();
		}
		catch(DomainException e) {
			System.out.println("Ocorreu um erro na execução do programa: " + e.getMessage());
		}

	}

	public static List<Cliente> obterClientes(Scanner sc) {
		Main.limparConsole();
		System.out.println("Você está na etapa de cadastro de clientes.\n");

		char cadastrarOutroCliente = 'S';
		while(cadastrarOutroCliente == 'S') {
			System.out.print("Qual o nome do cliente? ");
			Cliente novoCliente = new Cliente(sc.nextLine());

			System.out.println("Dados do novo cliente: " + novoCliente);
			Main.clientes.add(novoCliente);

			System.out.print("\n\nDeseja cadastrar outro cliente (S/N)? ");
			cadastrarOutroCliente = sc.nextLine().charAt(0);
			Main.limparConsole();
		}

		return clientes;
	}

	private static void limparConsole() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("\b") ;
		}
	}

}
