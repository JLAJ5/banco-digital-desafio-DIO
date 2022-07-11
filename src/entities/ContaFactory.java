package entities;

import entities.Exceptions.DomainException;

public class ContaFactory {
    
    public Conta getInstance(String tipoDeConta, Cliente cliente) throws DomainException {
        if(tipoDeConta.toLowerCase().equals("corrente")) {
            return new ContaCorrente(cliente);
        }
        else if(tipoDeConta.toLowerCase().equals("poupança") || tipoDeConta.toLowerCase().equals("poupanca")) {
            return new ContaPoupanca(cliente);
        }

        throw new DomainException("O tipo de conta fornecido foi inválido.");
    }

}
