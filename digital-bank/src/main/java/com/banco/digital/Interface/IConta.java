package com.banco.digital.Interface;

import com.banco.digital.exceptions.SaldoInsuficienteException;
import com.banco.digital.models.Conta;

public interface IConta {

    void depositar(double valor);

    void sacar(double valor) throws SaldoInsuficienteException;

    void transferir(double valor, Conta contaDestino) throws SaldoInsuficienteException;

    void imprimirExtrato();


}
