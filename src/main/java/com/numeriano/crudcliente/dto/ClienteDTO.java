package com.numeriano.crudcliente.dto;

import com.numeriano.crudcliente.model.Cliente;
import com.numeriano.crudcliente.model.Email;
import com.numeriano.crudcliente.model.Endereco;
import com.numeriano.crudcliente.model.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;

    @Valid
    @NotEmpty
    private String nome;

    @Valid
    @NotEmpty
    private String cpf;

    @Valid
    @NotEmpty
    private Endereco endereco;

    @Valid
    @NotEmpty
    private List<Telefone> telefones = new ArrayList<>();

    @Valid
    @NotEmpty
    private List<Email> emails = new ArrayList<>();

    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.endereco = cliente.getEndereco();
        this.telefones = cliente.getTelefones();
        this.emails = cliente.getEmails();
    }
}
