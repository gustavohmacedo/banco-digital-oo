package com.banco.digital.models;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void depositar(double valor) {

        this.saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado com sucesso!", valor);
        System.out.println();
    }

    @Override
    public void sacar(double valor) {
        double limiteMaximoParaTransacao = this.saldo;

        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso!", valor);
            System.out.println();
        } else {
            System.out.println("\nSaque indispónivel para este valor.");
            System.out.printf("Favor, sacar um valor máximo de R$ %.2f", limiteMaximoParaTransacao);
            System.out.println();
        }

    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        double limiteMaximoParaTransacao = this.saldo;

        if (this.saldo >= valor) {
            contaDestino.saldo += valor;
            this.saldo -= valor;
            System.out.println();
            System.out.printf("Transferência de R$ %.2f realizada com sucesso!", valor);
            System.out.println();
            System.out.printf("Da [Ag: %d - Número: %d] Para [Ag: %d - Número: %d]",
                    this.agencia, this.numero, contaDestino.agencia, contaDestino.numero);
            System.out.println();


        } else {
            System.out.println();
            System.out.println("\nTransferência indispónivel para este valor.");
            System.out.printf("Favor, transferir um valor máximo de R$ %.2f", limiteMaximoParaTransacao);
            System.out.println();

        }

    }

    @Override
    public void imprimirExtrato() {
        System.out.println("================[ Extrato Conta Corrente ]====================");
        super.imprimirInformacoes();
    }


}