package com.numeriano.crudcliente.model;

import com.numeriano.crudcliente.dto.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @ManyToOne
    @JoinColumn
    private Endereco endereco;

    @ElementCollection
    @CollectionTable(name = "cliente_telefone",
            joinColumns = @JoinColumn(name = "cliente_codigo"))
    @Column(name = "telefone_numero", length = 20, nullable = false)
    private List<Telefone> telefones = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "cliente_email",
            joinColumns = @JoinColumn(name = "cliente_codigo"))
    @Column(name = "endereco_virtual", length = 40, nullable = false)
    private List<Email> emails = new ArrayList<>();


    public Cliente(ClienteDTO clienteDTO){
        this.id = clienteDTO.getId();
        this.nome = clienteDTO.getNome();
        this.cpf = clienteDTO.getCpf();
        this.endereco = clienteDTO.getEndereco();
        this.telefones = clienteDTO.getTelefones();
        this.emails = clienteDTO.getEmails();
    }
}
