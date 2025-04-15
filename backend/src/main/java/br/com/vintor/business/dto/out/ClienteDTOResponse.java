package br.com.vintor.business.dto.out;

import br.com.vintor.business.dto.EnderecoDTO;
import br.com.vintor.business.dto.TelefoneDTO;
import br.com.vintor.infrastructure.entities.enums.TipoDocumento;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ClienteDTOResponse {

    private String nome;
    private LocalDate dataNascimento;

    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String email;

    private Set<TelefoneDTO> telefones;

    private Set<EnderecoDTO> enderecos;

    private Set<VendaDTOResponse> vendas = new HashSet<>();

    public ClienteDTOResponse() {
    }

    public ClienteDTOResponse(String nome, LocalDate dataNascimento, TipoDocumento tipoDocumento, String numeroDocumento, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.email = email;
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

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
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

    public Set<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public Set<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public Set<VendaDTOResponse> getVendas() {
        return vendas;
    }
}
