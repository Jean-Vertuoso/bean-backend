package br.com.vintor.infrastructure.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Telefone implements Serializable {

    private String ddd;
    private String numero;

    public Telefone() {
    }

    public Telefone(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(ddd, telefone.ddd) && Objects.equals(numero, telefone.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddd, numero);
    }
}
