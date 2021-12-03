package com.numeriano.crudcliente.dto;

import com.numeriano.crudcliente.model.Endereco;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class EnderecoDTO {

    private Long id;

    @Valid
    @NotEmpty
    private String cep;

    @Valid
    @NotEmpty
    private String logradouro;

    @Valid
    @NotEmpty
    private String bairro;

    @Valid
    @NotEmpty
    private String cidade;

    @Valid
    @NotEmpty
    private String uf;

    private String complemento;
}
