package br.com.bean.business.dto.in;

import br.com.bean.business.dto.AddressDto;
import br.com.bean.business.dto.PhoneDto;
import br.com.bean.business.enums.DocumentType;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ClientDtoRequest {

    private String name;
    private LocalDate birthDate;
    private DocumentType documentType;
    private String documentNumber;
    private String email;

    private Set<PhoneDto> phones = new HashSet<>();
    private Set<AddressDto> addresses = new HashSet<>();;

    public ClientDtoRequest() {
    }

    public ClientDtoRequest(String name, LocalDate birthDate, DocumentType documentType, String documentNumber, String email) {
        this.name = name;
        this.birthDate = birthDate;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<PhoneDto> getPhones() {
        return phones;
    }

    public Set<AddressDto> getAddresses() {
        return addresses;
    }
}
