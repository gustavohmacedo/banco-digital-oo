package com.banco.digital.main;

import com.banco.digital.exceptions.SaldoInsuficienteException;
import com.banco.digital.models.Banco;
import com.banco.digital.models.Cliente;
import com.banco.digital.models.Conta;
import com.banco.digital.models.ContaCorrente;
import com.banco.digital.models.ContaPoupanca;

import java.util.Arrays;
import java.util.List;

public class OperacaoConta {

    public static void main(String[] args) {

        Cliente cliente01 = new Cliente("Gustavo Henrique", "gustavohm2008@hotmail.com", "(11)4000-5000");
        Cliente cliente02 = new Cliente("Peter Henrique", "peter.henrique@hotmail.com", "(11)3003-5005");

        Conta cc = new ContaCorrente(cliente01);
        cc.imprimirExtrato();
        cc.depositar(50);
        cc.imprimirExtrato();

        try {
            cc.sacar(51);
        } catch (SaldoInsuficienteException ex) {
            System.out.println("Exception" + ex.getMessage());
        }

        cc.imprimirExtrato();

        System.out.println();

        Conta cp = new ContaPoupanca(cliente02);
        cp.imprimirExtrato();
        cp.depositar(150);
        cp.imprimirExtrato();

        try {
            cp.sacar(150);
        } catch (SaldoInsuficienteException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        cp.imprimirExtrato();

        try {
            cp.transferir(45, cc);
        } catch (SaldoInsuficienteException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        cp.imprimirExtrato();

        System.out.println("\n");
        cc.imprimirExtrato();

        System.out.println("\n");

        List<Conta> contas = Arrays.asList(cc, cp);
        List<Cliente> clietes = Arrays.asList(cliente01, cliente02);

        Banco nuPagamentos = new Banco(0260, "Nubank", contas, clietes);
        System.out.println(nuPagamentos.informacoesDoBanco());

        System.out.println("=============[ Lista de Contas cadastradas ]=================");
        nuPagamentos.listarContas();

        System.out.println("==================[ Lista de Clientes ]======================");
        nuPagamentos.listarClientes();

    }
}
