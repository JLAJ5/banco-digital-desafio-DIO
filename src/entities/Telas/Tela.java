package entities.Telas;

import java.util.Scanner;

import entities.Exceptions.CancelarAcaoException;

public abstract class Tela {
    
    protected Scanner sc;

    public Tela(Scanner sc) {
        this.sc = sc;
    }

    protected void imprimirCabecalho(String cabecalho) {
        this.limparConsole();
        System.out.println(cabecalho);
        System.out.println("Para sair, digite \"Cancelar\" em qualquer momento.\n\n");
    }

    protected void limparConsole() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("\b") ;
		}
    }

    public abstract void obterDados();

    protected final void throwSeCancelou(String userInput) throws CancelarAcaoException {
        if(userInput.toLowerCase().equals("cancelar")) {
            throw new CancelarAcaoException();
        }
    }

}