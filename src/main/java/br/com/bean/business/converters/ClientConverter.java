package br.com.bean.business.converters;

import br.com.bean.business.dto.AddressDto;
import br.com.bean.business.dto.PhoneDto;
import br.com.bean.business.dto.in.ClientDtoRequest;
import br.com.bean.business.dto.out.ClientDtoResponse;
import br.com.bean.infrastructure.entities.Address;
import br.com.bean.infrastructure.entities.Client;
import br.com.bean.infrastructure.entities.Phone;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClientConverter {

    public Client dtoToEntity(ClientDtoRequest dto){
        Client entity = new Client();

        entity.setName(dto.getName());
        entity.setBirthDate(dto.getBirthDate());
        entity.setDocumentType(dto.getDocumentType());
        entity.setDocumentNumber(dto.getDocumentNumber());
        entity.setEmail(dto.getEmail());
        entity.getPhones().addAll(toPhoneEntityList(dto.getPhones()));
        entity.getAddresses().addAll(toAddressEntityList(dto.getAddresses()));

        return entity;
    }

    public ClientDtoResponse entityToDto(Client entity){
        ClientDtoResponse dto = new ClientDtoResponse();

        dto.setName(entity.getName());
        dto.setBirthDate(entity.getBirthDate());
        dto.setDocumentType(entity.getDocumentType());
        dto.setDocumentNumber(entity.getDocumentNumber());
        dto.setEmail(entity.getEmail());
        dto.getPhones().addAll(toPhoneDtoList(entity.getPhones()));
        dto.getAddresses().addAll(toAddressDtoList(entity.getAddresses()));

        return dto;
    }

    private Set<Phone> toPhoneEntityList(Set<PhoneDto> dtoList){
        return dtoList.stream().map(this::phoneDtoToEntity).collect(Collectors.toSet());
    }

    private Phone phoneDtoToEntity(PhoneDto dto){
        Phone entity = new Phone();

        entity.setAreaCode(dto.getAreaCode());
        entity.setNumber(dto.getNumber());

        return entity;
    }

    private Set<Address> toAddressEntityList(Set<AddressDto> dtoList){
        return dtoList.stream().map(this::addressDtoToEntity).collect(Collectors.toSet());
    }

    private Address addressDtoToEntity(AddressDto dto){
        Address entity = new Address();

        entity.setPostalCode(dto.getPostalCode());
        entity.setStreet(dto.getStreet());
        entity.setNumber(dto.getNumber());
        entity.setNeighborhood(dto.getNeighborhood());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());

        return entity;
    }

    private Set<PhoneDto> toPhoneDtoList(Set<Phone> entityList){
        return entityList.stream().map(this::phoneEntityToDto).collect(Collectors.toSet());
    }

    private PhoneDto phoneEntityToDto(Phone entity){
        PhoneDto dto = new PhoneDto();

        dto.setAreaCode(entity.getAreaCode());
        dto.setNumber(entity.getNumber());

        return dto;
    }

    private Set<AddressDto> toAddressDtoList(Set<Address> entityList){
        return entityList.stream().map(this::addressEntityToDto).collect(Collectors.toSet());
    }

    private AddressDto addressEntityToDto(Address entity){
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
