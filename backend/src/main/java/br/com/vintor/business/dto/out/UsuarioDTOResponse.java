package br.com.vintor.business.dto.out;

import br.com.vintor.business.dto.FuncaoDTO;

import java.util.HashSet;
import java.util.Set;

public class UsuarioDTOResponse {

    private Long id;
    private String nome;
    private String email;
    private String senha;

    private Set<VendaDTOResponse> vendas = new HashSet<>();

    private Set<FuncaoDTO> funcoes = new HashSet<>();

    public UsuarioDTOResponse() {
    }

    public UsuarioDTOResponse(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<VendaDTOResponse> getVendas() {
        return vendas;
    }

    public Set<FuncaoDTO> getFuncoes() {
        return funcoes;
    }
}
