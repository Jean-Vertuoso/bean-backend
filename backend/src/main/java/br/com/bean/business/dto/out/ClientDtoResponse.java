package br.com.bean.business.dto.out;

import br.com.bean.business.enums.DocumentType;

import java.time.LocalDate;

public class ClientDtoResponse {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private DocumentType documentType;
    private String documentNumber;
    private String email;

    public ClientDtoResponse() {
    }

    public ClientDtoResponse(Long id, String name, LocalDate birthDate, DocumentType documentType, String documentNumber, String email) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
