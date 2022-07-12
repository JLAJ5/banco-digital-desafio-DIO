package entities.Telas;

import java.util.List;
import java.util.Scanner;

import entities.Conta;

public class TelaDeListagemDeContas extends Tela {

	private List<Conta> contas;

	public TelaDeListagemDeContas(List<Conta> contas, Scanner sc) {
		super(sc);
		this.contas = contas;
	}

    private void imprimirCabecalho() {
        super.imprimirCabecalho("Você está na tela de listagem de contas.\nPara sair, pressione \"Enter\".\n\n");
    }

    public void imprimirTela() {
		this.imprimirCabecalho();

		for(Conta c : this.contas) {
			System.out.println(c);
		}

        sc.nextLine();
    }
    
}