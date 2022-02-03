package com.banco.digital.Interface;

import com.banco.digital.models.Conta;

public interface IConta {

    void depositar(double valor);

    void sacar(double valor);

    void transferir(double valor, Conta contaDestino);

    void imprimirExtrato();


}
