package br.com.vintor.infrastructure.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_funcao")
public class Funcao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String funcao;

    @ManyToMany(mappedBy = "funcoes")
    private Set<Usuario> usuarios = new HashSet<>();

    public Funcao() {
    }

    public Funcao(Long id, String funcao) {
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

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcao funcao = (Funcao) o;
        return Objects.equals(id, funcao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
