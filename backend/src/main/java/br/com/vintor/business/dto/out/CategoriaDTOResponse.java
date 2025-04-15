package br.com.vintor.business.dto.out;

import java.util.HashSet;
import java.util.Set;

public class CategoriaDTOResponse {

    private Long id;
    private String nome;

    private Set<ProdutoDTOResponse> produtos = new HashSet<>();

    public CategoriaDTOResponse() {
    }

    public CategoriaDTOResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public Set<ProdutoDTOResponse> getProdutos() {
        return produtos;
    }
}
