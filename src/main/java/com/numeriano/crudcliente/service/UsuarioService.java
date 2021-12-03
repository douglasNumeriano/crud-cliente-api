package com.numeriano.crudcliente.service;

import com.numeriano.crudcliente.dto.MessageResponseDTO;
import com.numeriano.crudcliente.dto.UsuarioDTO;
import com.numeriano.crudcliente.exception.AutenticacaoException;
import com.numeriano.crudcliente.exception.ValidacaoException;
import com.numeriano.crudcliente.model.Cliente;
import com.numeriano.crudcliente.model.Usuario;
import com.numeriano.crudcliente.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO autenticar(String login, String senha){
      Optional<Usuario> usuario = usuarioRepository.findByLogin(login);

      if(!usuario.isPresent()){
          throw new AutenticacaoException("Usuário não cadastrado");
      }

      if(!usuario.get().getSenha().equals(senha)){
          throw new AutenticacaoException("Senha inválida");
      }

      return new UsuarioDTO(usuario.get());
    }

    public MessageResponseDTO createUsuario(UsuarioDTO usuarioDTO){
        validarLogin(usuarioDTO.getLogin());
        Usuario usuarioSave = new Usuario(usuarioDTO);
        Usuario usuario = usuarioRepository.save(usuarioSave);
        return MessageResponseDTO
                .builder()
                .message("Usuário criado com sucesso")
                .build();
    }

    public void validarLogin(String login){
        boolean existe = usuarioRepository.existsByLogin(login);

        if(existe){
            throw new ValidacaoException("Já existe um usuário cadastrado com este login.");
        }
    }

}
