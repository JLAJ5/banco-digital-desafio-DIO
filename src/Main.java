import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaFactory;
import entities.ContaPoupanca;
import entities.Exceptions.DomainException;

public class Main {

	private static List<Cliente> clientes = new ArrayList<>();
	private static List<Conta> contas = new ArrayList<>();

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

	public static void cadastroDeClientes(Scanner sc) {
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
	}

	public static void aberturaDeContas(Scanner sc) {
		Main.limparConsole();
		System.out.println("Você está na etapa de criação de contas.\n");

		ContaFactory cf = new ContaFactory();
		char cadastrarOutraConta = 'S';
		while(cadastrarOutraConta == 'S') {
			System.out.print("Qual o ID do cliente? ");
			int idCliente = sc.nextInt();
			sc.nextLine(); // Limpando o buffer de entrada
			Cliente cliente = Main.clientes.stream().filter(x -> x.getId() == idCliente).findFirst().orElse(null);

			if(cliente == null) {
				System.out.println("O cliente não foi encontrado.\n\n");
				continue;
			}

			Conta novaConta = null;
			try {
				System.out.print("Qual o tipo de conta (Corrente/Poupanca)? ");
				novaConta = cf.getInstance(sc.nextLine(), cliente);
			}
			catch (DomainException e) {
				Main.limparConsole();
				System.out.println(e.getMessage() + "\n\n");
				continue;
			}

			System.out.println("Dados do novo cliente: " + novaConta);
			Main.contas.add(novaConta);

			System.out.print("\n\nDeseja abrir outra conta (S/N)? ");
			cadastrarOutraConta = sc.nextLine().charAt(0);
			Main.limparConsole();
		}
	}

	private static void limparConsole() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("\b") ;
		}
	}

}
