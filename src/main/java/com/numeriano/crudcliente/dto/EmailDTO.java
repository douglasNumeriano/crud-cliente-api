package com.numeriano.crudcliente.dto;

import javax.validation.constraints.NotEmpty;

public class EmailDTO {

    @NotEmpty
    private String enderecoVirtual;
}
