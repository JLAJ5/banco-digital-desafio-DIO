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
    }

    public abstract void imprimirTela();

    protected void limparConsole() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("\b") ;
		}
    }

    protected final void throwSeCancelou(String userInput) throws CancelarAcaoException {
        if(userInput.toLowerCase().equals("cancelar")) {
            throw new CancelarAcaoException();
        }
    }

}