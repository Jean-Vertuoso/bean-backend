package br.com.vintor.business.converters;

import br.com.vintor.business.dto.in.ClienteDTORequest;
import br.com.vintor.infrastructure.entities.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter {

    public Cliente paraClienteEntity(ClienteDTORequest clienteDTO){
        Cliente entity = new Cliente();

        entity.setNome(clienteDTO.getNome());
        entity.setDataNascimento(clienteDTO.getDataNascimento());
        entity.setTipoDocumento(clienteDTO.getTipoDocumento());
        entity.setNumeroDocumento(clienteDTO.getNumeroDocumento());
        entity.setEmail(clienteDTO.getEmail());

        return entity;
    }
}
