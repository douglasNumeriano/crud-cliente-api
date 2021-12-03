package com.numeriano.crudcliente.dto;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class TelefoneDTO {

    @Valid
    @NotEmpty
    private String tipoTelefone;

    @Valid
    @NotEmpty
    private String numero;
}
