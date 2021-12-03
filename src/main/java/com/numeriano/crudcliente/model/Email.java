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
public class Email {

    @Column(nullable = false)
    private String enderecoVirtual;

}
