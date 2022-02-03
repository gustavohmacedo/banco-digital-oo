package com.banco.digital.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Cliente {

    @Getter @Setter private String nome;
    @Getter @Setter private String email;
    @Getter @Setter private String telefone;

}
