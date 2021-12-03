package com.numeriano.crudcliente.model;


import com.numeriano.crudcliente.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = true)
    private boolean tipoAdmin;

    public Usuario(UsuarioDTO usuarioDTO){
        this.id = usuarioDTO.getId();
        this.login = usuarioDTO.getLogin();
        this.senha = usuarioDTO.getSenha();
        this.tipoAdmin = usuarioDTO.isTipoAdmin();
    }
}
