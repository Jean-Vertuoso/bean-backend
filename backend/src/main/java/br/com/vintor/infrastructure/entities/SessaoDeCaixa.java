package br.com.vintor.infrastructure.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_sessao_de_caixa")
public class SessaoDeCaixa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant dataHoraAbertura;
    private Instant dataHoraFechamento;
    private BigDecimal valorInicial;
    private BigDecimal valorFinal;
    private BigDecimal valorEsperado;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @Column(nullable = false)
    private Boolean encerrada;

    @ManyToOne
    @JoinColumn(name = "operador_id")
    private Usuario operador;

    @OneToMany(mappedBy = "sessaoDeCaixa")
    private Set<Venda> vendas = new HashSet<>();

    public SessaoDeCaixa() {
    }

    public SessaoDeCaixa(Long id, Usuario operador, Instant dataHoraAbertura, Instant dataHoraFechamento, BigDecimal valorInicial, BigDecimal valorFinal, BigDecimal valorEsperado, String observacoes, Boolean encerrada) {
        this.id = id;
        this.operador = operador;
        this.dataHoraAbertura = dataHoraAbertura;
        this.dataHoraFechamento = dataHoraFechamento;
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

    public Set<Venda> getVendas(){
        return vendas;
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
