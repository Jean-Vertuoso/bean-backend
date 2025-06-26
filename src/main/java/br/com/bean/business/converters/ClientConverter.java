package br.com.bean.business.converters;

import br.com.bean.business.dto.AddressDto;
import br.com.bean.business.dto.ClientDto;
import br.com.bean.business.dto.PhoneDto;
import br.com.bean.infrastructure.entities.Address;
import br.com.bean.infrastructure.entities.Client;
import br.com.bean.infrastructure.entities.Phone;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ClientConverter {

    public Client dtoToEntity(ClientDto dto){
        Client entity = new Client();

        entity.setName(dto.getName());
        entity.setBirthDate(dto.getBirthDate());
        entity.setDocumentType(dto.getDocumentType());
        entity.setDocumentNumber(dto.getDocumentNumber());
        entity.setEmail(dto.getEmail());
        entity.getPhones().addAll(dto.getPhones().stream().map(this::dtoToEntity).collect(Collectors.toSet()));
        entity.getAddresses().addAll(dto.getAddresses().stream().map(this::dtoToEntity).collect(Collectors.toSet()));

        return entity;
    }

    public ClientDto entityToDto(Client entity){
        ClientDto dto = new ClientDto();

        dto.setName(entity.getName());
        dto.setBirthDate(entity.getBirthDate());
        dto.setDocumentType(entity.getDocumentType());
        dto.setDocumentNumber(entity.getDocumentNumber());
        dto.setEmail(entity.getEmail());
        dto.getPhones().addAll(entity.getPhones().stream().map(this::entityToDto).collect(Collectors.toSet()));
        dto.getAddresses().addAll(entity.getAddresses().stream().map(this::entityToDto).collect(Collectors.toSet()));

        return dto;
    }

    private Phone dtoToEntity(PhoneDto dto){
        Phone entity = new Phone();

        entity.setAreaCode(dto.getAreaCode());
        entity.setNumber(dto.getNumber());

        return entity;
    }

    private Address dtoToEntity(AddressDto dto){
        Address entity = new Address();

        entity.setPostalCode(dto.getPostalCode());
        entity.setStreet(dto.getStreet());
        entity.setNumber(dto.getNumber());
        entity.setNeighborhood(dto.getNeighborhood());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());

        return entity;
    }

    private PhoneDto entityToDto(Phone entity){
        PhoneDto dto = new PhoneDto();

        dto.setAreaCode(entity.getAreaCode());
        dto.setNumber(entity.getNumber());

        return dto;
    }

    private AddressDto entityToDto(Address entity){
        AddressDto dto = new AddressDto();

        dto.setPostalCode(entity.getPostalCode());
        dto.setStreet(entity.getStreet());
        dto.setNumber(entity.getNumber());
        dto.setNeighborhood(entity.getNeighborhood());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());

        return dto;
    }
}
