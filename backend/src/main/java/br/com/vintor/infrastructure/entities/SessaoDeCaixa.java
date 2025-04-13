package br.com.vintor.infrastructure.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class SessaoDeCaixa implements Serializable {

    private Long id;
    private Usuario operador;
    private Instant abertura;
    private Instant fechamento;
    private BigDecimal valorInicial;
    private BigDecimal valorFinal;
    private BigDecimal valorEsperado;
    private String observacoes;
    private Boolean encerrada;

    public SessaoDeCaixa() {
    }

    public SessaoDeCaixa(Long id, Usuario operador, Instant abertura, Instant fechamento, BigDecimal valorInicial, BigDecimal valorFinal, BigDecimal valorEsperado, String observacoes, Boolean encerrada) {
        this.id = id;
        this.operador = operador;
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.valorEsperado = valorEsperado;
        this.observacoes = observacoes;
        this.encerrada = encerrada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getOperador() {
        return operador;
    }

    public void setOperador(Usuario operador) {
        this.operador = operador;
    }

    public Instant getAbertura() {
        return abertura;
    }

    public void setAbertura(Instant abertura) {
        this.abertura = abertura;
    }

    public Instant getFechamento() {
        return fechamento;
    }

    public void setFechamento(Instant fechamento) {
        this.fechamento = fechamento;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public BigDecimal getValorEsperado() {
        return valorEsperado;
    }

    public void setValorEsperado(BigDecimal valorEsperado) {
        this.valorEsperado = valorEsperado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Boolean getEncerrada() {
        return encerrada;
    }

    public void setEncerrada(Boolean encerrada) {
        this.encerrada = encerrada;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SessaoDeCaixa that = (SessaoDeCaixa) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
