package com.numeriano.crudcliente.dto;

import com.numeriano.crudcliente.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;

    @NotEmpty
    private String login;

    @NotEmpty
    private String senha;
    
    private boolean tipoAdmin;

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.tipoAdmin = usuario.isTipoAdmin();
    }

}
