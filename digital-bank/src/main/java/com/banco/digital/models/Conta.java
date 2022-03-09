package com.banco.digital.models;

import com.banco.digital.Interface.IConta;
import com.banco.digital.exceptions.SaldoInsuficienteException;
import lombok.Getter;
import lombok.Setter;

public abstract class Conta implements IConta {

    private static final Integer AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    @Getter
    protected Integer agencia;

    @Getter
    protected Integer numero;

    @Getter
    protected Double saldo;

    @Getter
    @Setter
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.saldo = 0d;
    }

    protected void imprimirInformacoes() {
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Número: " + this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);

    }

    protected double vericarSaldoDisponivel(double valor) throws SaldoInsuficienteException {

        if (this.saldo < valor) {
            System.out.println("Operação Indisponível para o valor informado.");
            throw new SaldoInsuficienteException("Saldo da Conta R$ " + this.saldo + " | " + "valor R$ " + valor);
        }
        return valor;
    }


}


