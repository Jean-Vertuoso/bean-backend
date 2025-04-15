package br.com.vintor.business.dto.in;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class SessaoDeCaixaDTORequest {

    private Instant dataHoraAbertura;
    private Instant dataHoraFechamento;
    private BigDecimal valorInicial;
    private BigDecimal valorFinal;
    private BigDecimal valorEsperado;

    private String observacoes;

    private Boolean encerrada;

    private UsuarioDTORequest operador;

    private Set<VendaDTORequest> vendas = new HashSet<>();

    public SessaoDeCaixaDTORequest() {
    }

    public SessaoDeCaixaDTORequest(Instant dataHoraAbertura, Instant dataHoraFechamento, BigDecimal valorInicial, BigDecimal valorFinal, BigDecimal valorEsperado, String observacoes, Boolean encerrada, UsuarioDTORequest operador) {
        this.dataHoraAbertura = dataHoraAbertura;
        this.dataHoraFechamento = dataHoraFechamento;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.valorEsperado = valorEsperado;
        this.observacoes = observacoes;
        this.encerrada = encerrada;
        this.operador = operador;
    }

    public Instant getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(Instant dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public Instant getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(Instant dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
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

    public UsuarioDTORequest getOperador() {
        return operador;
    }

    public void setOperador(UsuarioDTORequest operador) {
        this.operador = operador;
    }

    public Set<VendaDTORequest> getVendas() {
        return vendas;
    }
}
