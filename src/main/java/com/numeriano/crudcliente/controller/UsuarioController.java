package com.numeriano.crudcliente.controller;

import com.numeriano.crudcliente.dto.UsuarioDTO;
import com.numeriano.crudcliente.exception.AutenticacaoException;
import com.numeriano.crudcliente.exception.ValidacaoException;
import com.numeriano.crudcliente.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity createUsuario(@RequestBody UsuarioDTO usuarioDTO){
        try{
            return new ResponseEntity(usuarioService.createUsuario(usuarioDTO), HttpStatus.CREATED);
        }
        catch(ValidacaoException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/autenticar")
    public ResponseEntity autenticar(@RequestBody UsuarioDTO usuarioDTO){
        try{
            UsuarioDTO usuarioDTOAutenticado = usuarioService.autenticar(usuarioDTO.getLogin(), usuarioDTO.getSenha());
            return ResponseEntity.ok(usuarioDTOAutenticado);
        } catch (AutenticacaoException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
