package br.com.bean.business.services;

import br.com.bean.business.converters.ClientConverter;
import br.com.bean.business.dto.ClientDto;
import br.com.bean.infrastructure.entities.Client;
import br.com.bean.infrastructure.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepository repository;
    private final ClientConverter converter;

    public ClientService(ClientRepository repository, ClientConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Transactional
    public ClientDto saveClient(ClientDto dto){
        Client entity = converter.dtoToEntity(dto);
        return converter.entityToDto(repository.save(entity));
    }
}
