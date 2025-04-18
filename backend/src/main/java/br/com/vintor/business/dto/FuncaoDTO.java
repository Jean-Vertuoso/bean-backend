package br.com.vintor.business.dto;

import br.com.vintor.business.dto.in.UsuarioDTORequest;

import java.util.HashSet;
import java.util.Set;

public class FuncaoDTO {

    private Long id;
    private String funcao;

    private Set<UsuarioDTORequest> usuarios = new HashSet<>();

    public FuncaoDTO() {
    }

    public FuncaoDTO(Long id, String funcao) {
        this.id = id;
        this.funcao = funcao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Set<UsuarioDTORequest> getUsuarios() {
        return usuarios;
    }
}