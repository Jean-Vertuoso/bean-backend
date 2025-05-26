package br.com.bean.business.services;

import br.com.bean.business.converters.ClientConverter;
import br.com.bean.business.dto.in.ClientDtoRequest;
import br.com.bean.business.dto.out.ClientDtoResponse;
import br.com.bean.infrastructure.entities.Client;
import br.com.bean.infrastructure.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private ClientConverter clientConverter;

    public ClientService(ClientRepository clientRepository, ClientConverter clientConverter) {
        this.clientRepository = clientRepository;
        this.clientConverter = clientConverter;
    }

    public ClientDtoResponse saveClient(ClientDtoRequest dto){
        Client entity = clientConverter.dtoToEntity(dto);
        return clientConverter.entityToDto(clientRepository.save(entity));
    }
}
