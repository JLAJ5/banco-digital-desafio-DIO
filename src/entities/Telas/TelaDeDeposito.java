package entities.Telas;

import java.util.List;
import java.util.Scanner;

import entities.Conta;
import entities.Exceptions.CancelarAcaoException;

public class TelaDeDeposito extends Tela {

    private List<Conta> contas;

    public TelaDeDeposito(List<Conta> contas, Scanner sc) {
        super(sc);
        this.contas = contas;
    }

    private void imprimirCabecalho() {
        super.imprimirCabecalho(
                "Você está na tela de depósito.\nPara sair, digite \"Cancelar\" em qualquer momento.\n\n");
    }

    @Override
    public void imprimirTela() {
        this.imprimirCabecalho();

        try {
            char realizarOutroDeposito = 'S';
            while (realizarOutroDeposito == 'S') {
                String inputUsuario = "";

                System.out.print("Qual o número da conta? ");
                inputUsuario = this.sc.nextLine();
                this.throwSeCancelou(inputUsuario);
                int numeroConta = Integer.parseInt(inputUsuario);

                System.out.print("Qual o número da agência? ");
                inputUsuario = this.sc.nextLine();
                this.throwSeCancelou(inputUsuario);
                int numeroAgencia = Integer.parseInt(inputUsuario);

                Conta conta = this.contas.stream()
                        .filter(x -> x.getAgencia() == numeroAgencia && x.getNumero() == numeroConta).findFirst()
                        .orElse(null);
                if (conta == null) {
                    this.imprimirCabecalho();
                    System.out.println(
                            "***Ocorreu um erro durante a operação: Nenhuma conta encontrada com o número e agencia fornecidos.\n\n");
                    continue;
                }

                System.out.print("Quanto você deseja depositar? R$ ");
                inputUsuario = this.sc.nextLine();
                this.throwSeCancelou(inputUsuario);
                conta.depositar(Double.parseDouble(inputUsuario));
                System.out.printf("\n\nSeu saldo atual: R$ %.2f\n", conta.getSaldo());

                System.out.print("\n\nDeseja realizar outro deposito (S/N)? ");
                realizarOutroDeposito = this.sc.nextLine().charAt(0);

                if (realizarOutroDeposito == 'S') {
                    this.imprimirCabecalho();
                }
            }
        } catch (CancelarAcaoException e) {
        }
    }

}
