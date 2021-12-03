package com.numeriano.crudcliente.controller;

import com.numeriano.crudcliente.dto.ClienteDTO;
import com.numeriano.crudcliente.dto.MessageResponseDTO;
import com.numeriano.crudcliente.exception.ClienteException;
import com.numeriano.crudcliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listAll(){
        List<ClienteDTO> clienteDTOList = clienteService.listAll();
        return ResponseEntity.ok(clienteDTOList);
    }

    @GetMapping("/{id}")
    public ClienteDTO findById(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody @Valid ClienteDTO clienteDTO){
        try{
            return new ResponseEntity<>(clienteService.createCliente(clienteDTO), HttpStatus.CREATED);
        }
        catch(ClienteException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id,
                                         @RequestBody @Valid ClienteDTO clienteDTO)
    throws ClienteException{
        return clienteService.updateById(id, clienteDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        clienteService.delete(id);
    }
}
