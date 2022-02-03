package com.banco.digital.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class Banco {

    @Getter private Integer codigo;
    @Getter @Setter private String nome;
    @Getter private List<Conta> contas;
    @Getter private List<Cliente> clientes;

    public void listarContas() {
        for (Conta conta : contas) {
            System.out.println("Ag: " + conta.getAgencia() + "-" + "Conta: " + conta.numero);
        }
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println("Sr(a). " + cliente.getNome());
        }
    }

    public String informacoesDoBanco() {
        System.out.println("========================[ Banco ]============================");
        return "Nome: " + nome + "\n" +
                "Código: " + codigo;

    }
}

