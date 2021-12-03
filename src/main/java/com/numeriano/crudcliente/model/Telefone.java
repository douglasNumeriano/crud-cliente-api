package com.numeriano.crudcliente.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {

    @Column(nullable = false)
    private String tipoTelefone;

    @Column(nullable = false)
    private String numero;
}
