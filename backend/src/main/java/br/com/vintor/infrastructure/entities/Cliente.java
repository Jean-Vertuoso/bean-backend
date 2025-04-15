package br.com.vintor.infrastructure.entities;

import br.com.vintor.infrastructure.entities.enums.TipoDocumento;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String email;

    @ElementCollection
    @CollectionTable(name = "tb_cliente_telefones", joinColumns = @JoinColumn(name = "client_id"))
    private Set<Telefone> telefones = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "tb_cliente_enderecos", joinColumns = @JoinColumn(name = "client_id"))
    private Set<Endereco> enderecos = new HashSet<>();;

    @OneToMany(mappedBy = "cliente")
    private Set<Venda> vendas = new HashSet<>();

    public Cliente() {
    }

    public Cliente(Long id, String nome, LocalDate dataNascimento, TipoDocumento tipoDocumento, String numeroDocumento, String email) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoDocumento getTipoDocumento(){
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento){
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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

    public Set<Venda> getVendas(){
        return vendas;
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
