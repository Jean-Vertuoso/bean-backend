package br.com.vintor.infrastructure.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class Cliente implements Serializable {

    private Long id;
    private String name;
    private Date dataNascimento;
    private String cpfOuCnpj;
    private String email;

    private Set<Telefone> telefones;
    private Set<Endereco> enderecos;

    public Cliente() {
    }

    public Cliente(Long id, String name, Date dataNascimento, String cpfOuCnpj, String email) {
        this.id = id;
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.cpfOuCnpj = cpfOuCnpj;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
