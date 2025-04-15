package br.com.vintor.business.dto.in;

import br.com.vintor.business.dto.FuncaoDTO;

import java.util.HashSet;
import java.util.Set;

public class UsuarioDTORequest {

    private String nome;
    private String email;
    private String senha;

    private Set<VendaDTORequest> vendas = new HashSet<>();

    private Set<FuncaoDTO> funcoes = new HashSet<>();

    public UsuarioDTORequest() {
    }

    public UsuarioDTORequest(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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

    public Set<VendaDTORequest> getVendas() {
        return vendas;
    }

    public Set<FuncaoDTO> getFuncoes() {
        return funcoes;
    }
}
