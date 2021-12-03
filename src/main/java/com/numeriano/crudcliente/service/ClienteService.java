package com.numeriano.crudcliente.service;


import com.numeriano.crudcliente.dto.ClienteDTO;
import com.numeriano.crudcliente.dto.MessageResponseDTO;
import com.numeriano.crudcliente.exception.*;
import com.numeriano.crudcliente.model.Cliente;
import com.numeriano.crudcliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<ClienteDTO> listAll(){
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteList.stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ClienteDTO findById(Long id){
        Cliente cliente = clienteRepository.getById(id);
        return new ClienteDTO(cliente);
    }

    public MessageResponseDTO createCliente(ClienteDTO clienteDTO) throws ClienteException{

            Cliente clienteSave = new Cliente(clienteDTO);
            Cliente cliente = clienteRepository.save(clienteSave);
            return MessageResponseDTO
                    .builder()
                    .message("Cliente criado com sucesso com ID: " + cliente.getId())
                    .build();
    }

    public MessageResponseDTO updateById(Long id, ClienteDTO clienteDTO) throws ClienteException{

        verifyIfExists(id);
        Cliente clienteUpdate = new Cliente(clienteDTO);
        Cliente cliente = clienteRepository.save(clienteUpdate);
        return MessageResponseDTO
                .builder()
                .message("Cliente " + cliente.getId() + " atualizado com sucesso")
                .build();
    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

    private Cliente verifyIfExists(Long id) throws ClienteException {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteException("Este cliente não foi encontrado"));
    }
}
