package entities;

import entities.Exceptions.DomainException;

public class ContaFactory {
    
    public Conta getInstance(String tipoDeConta, Cliente cliente) throws DomainException {
        if(tipoDeConta.equals("Corrente")) {
            return new ContaCorrente(cliente);
        }
        else if(tipoDeConta.equals("Poupança")) {
            return new ContaPoupanca(cliente);
        }

        throw new DomainException("O tipo de conta fornecido foi inválido.");
    }

}
