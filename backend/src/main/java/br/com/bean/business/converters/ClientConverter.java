package br.com.bean.business.converters;

import br.com.bean.business.dto.in.ClientDtoRequest;
import br.com.bean.infrastructure.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter {

    public Client toClientEntity(ClientDtoRequest clientDto){
        Client entity = new Client();

        entity.setName(clientDto.getName());
        entity.setBirthDate(clientDto.getBirthDate());
        entity.setDocumentType(clientDto.getDocumentType());
        entity.setDocumentNumber(clientDto.getDocumentNumber());
        entity.setEmail(clientDto.getEmail());

        return entity;
    }
}
