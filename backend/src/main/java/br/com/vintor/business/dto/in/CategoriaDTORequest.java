package br.com.vintor.business.dto.in;

import java.util.HashSet;
import java.util.Set;

public class CategoriaDTORequest {

    private String nome;

    private Set<ProdutoDTORequest> produtos = new HashSet<>();

    public CategoriaDTORequest() {
    }

    public CategoriaDTORequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<ProdutoDTORequest> getProdutos() {
        return produtos;
    }
}
