package br.com.bean.business.services;

import br.com.bean.business.converters.ClientConverter;
import br.com.bean.business.dto.ClientDto;
import br.com.bean.infrastructure.entities.Client;
import br.com.bean.infrastructure.exceptions.IllegalArgumentException;
import br.com.bean.infrastructure.exceptions.ResourceNotFoundException;
import br.com.bean.infrastructure.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;
    private final ClientConverter converter;
    private final EntityFinderService finderService;

    public ClientService(ClientRepository repository, ClientConverter converter, EntityFinderService finderService) {
        this.repository = repository;
        this.converter = converter;
        this.finderService = finderService;
    }

    @Transactional
    public ClientDto saveClient(ClientDto dto){
        Client entity = converter.dtoToEntity(dto);
        return converter.entityToDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<ClientDto> findAll(){
        return repository.findAll().stream().map(converter::entityToDto).toList();
    }

    @Transactional(readOnly = true)
    public List<ClientDto> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name).stream().map(converter::entityToDto).toList();
    }

    public Client getReferenceByIdOrThrow(Long id){
        return finderService.getReferenceByIdOrThrow(repository, id, "Client");
    }
}
