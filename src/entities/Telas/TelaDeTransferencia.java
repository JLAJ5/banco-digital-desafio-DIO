package entities.Telas;

import java.util.List;
import java.util.Scanner;

import entities.Conta;
import entities.Exceptions.CancelarAcaoException;
import entities.Exceptions.DomainException;

public class TelaDeTransferencia extends Tela {

	private List<Conta> contas;

	public TelaDeTransferencia(List<Conta> contas, Scanner sc) {
		super(sc);
		this.contas = contas;
	}

    private void imprimirCabecalho() {
        super.imprimirCabecalho("Você está na tela de saque.\nPara sair, digite \"Cancelar\" em qualquer momento.\n\n");
    }

    @Override
    public void imprimirTela() {
		this.imprimirCabecalho();

		try {
			char realizarOutraTransferencia = 'S';
			while(realizarOutraTransferencia == 'S') {
				String inputUsuario = "";
                String tipoDeConta = "origem";
                Conta contaDestino = null, contaOrigem = null;

                for(int i = 0; i < 2; i++) {
                    System.out.printf("Qual o número da conta de %s? ", tipoDeConta);
                    inputUsuario = this.sc.nextLine();
                    this.throwSeCancelou(inputUsuario);
                    int numeroConta = Integer.parseInt(inputUsuario);
            
                    System.out.printf("Qual o número da agência de %s? ", tipoDeConta);
                    inputUsuario = this.sc.nextLine();
                    this.throwSeCancelou(inputUsuario);
                    int numeroAgencia = Integer.parseInt(inputUsuario);
    
                    Conta conta = this.contas.stream().filter(x -> x.getAgencia() == numeroAgencia && x.getNumero() == numeroConta).findFirst().orElse(null);
                    if(conta == null) {
                        this.imprimirCabecalho();
                        System.out.printf("***Ocorreu um erro durante a operação: Nenhuma conta %s encontrada com o número e agencia fornecidos.\n\n", tipoDeConta);
                        i = 0;
                        tipoDeConta = "origem";
                        continue;
                    }

                    if(tipoDeConta == "origem") {
                        contaOrigem = conta;
                    }
                    else {
                        contaDestino = conta;
                    }

                    tipoDeConta = "destino";
                }

                System.out.printf("\n\nSaldo da conta de origem: R$ %.2f\n\n", contaOrigem.getSaldo());
                System.out.print("Quanto você deseja transferir? R$ ");
                try {
                    inputUsuario = this.sc.nextLine();
                    this.throwSeCancelou(inputUsuario);
                    contaOrigem.transferir((Double.parseDouble(inputUsuario)), contaDestino);
                }
                catch(DomainException e) {
					this.imprimirCabecalho();
					System.out.println("***Ocorreu um erro durante a operação: " + e.getMessage() + "\n\n");
					continue;
                }
    
                System.out.print("\n\nDeseja realizar outra transferência (S/N)? ");
                realizarOutraTransferencia = this.sc.nextLine().charAt(0);

				if(realizarOutraTransferencia == 'S') {
					this.imprimirCabecalho();
				}
			}
		}
		catch(CancelarAcaoException e) { }
    }
    
}
