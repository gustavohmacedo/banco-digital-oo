package com.banco.digital.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Cliente {

    private String nome;
    private String email;
    private String telefone;

}
