package br.com.bean.infrastructure.entities;

import br.com.bean.business.enums.DocumentType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;
    private String documentNumber;
    private String email;

    @ElementCollection
    @CollectionTable(name = "tb_client_phones", joinColumns = @JoinColumn(name = "client_id"))
    private Set<Phone> phones = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "tb_client_addresses", joinColumns = @JoinColumn(name = "client_id"))
    private Set<Address> addresses = new HashSet<>();;

    @OneToMany(mappedBy = "client")
    private Set<Sale> sales = new HashSet<>();

    public Client() {
    }

    public Client(Long id, String name, LocalDate birthDate, DocumentType documentType, String documentNumber, String email) {
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

    public Set<Phone> getPhones() {
        return phones;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Set<Sale> getOrders() {
        return sales;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
