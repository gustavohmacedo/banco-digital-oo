package com.banco.digital.models;

import com.banco.digital.exceptions.SaldoInsuficienteException;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void depositar(double valor) {

        this.saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado com sucesso!", valor);
        System.out.println();
    }

    public void sacar(double valor) throws SaldoInsuficienteException {

        super.vericarSaldoDisponivel(valor);
        this.saldo -= valor;
        System.out.printf("Saque de R$ %.2f realizado com sucesso!", valor);
        System.out.println();

        System.out.println();
    }

    public void transferir(double valor, Conta contaDestino) throws SaldoInsuficienteException {

        super.vericarSaldoDisponivel(valor);
        contaDestino.saldo += valor;
        this.saldo -= valor;
        System.out.println();
        System.out.printf("Transferência de R$ %.2f realizada com sucesso!", valor);
        System.out.println();
        System.out.printf("Da [Ag: %d - Número: %d] Para [Ag: %d - Número: %d]",
                this.agencia, this.numero, contaDestino.agencia, contaDestino.numero);
        System.out.println();

    }

    public void imprimirExtrato() {
        System.out.println("================[ Extrato Conta Poupança ]====================");
        super.imprimirInformacoes();
    }
}
