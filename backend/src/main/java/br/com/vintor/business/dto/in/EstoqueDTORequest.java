package br.com.vintor.business.dto.in;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EstoqueDTORequest {

    private Double quantidade;
    private Double quantidadeMinima;
    private BigDecimal valorTotal;
    private LocalDateTime ultimaAtualizacao;

    private ProdutoDTORequest produto;

    public EstoqueDTORequest() {
    }

    public EstoqueDTORequest(Double quantidade, Double quantidadeMinima, BigDecimal valorTotal, LocalDateTime ultimaAtualizacao, ProdutoDTORequest produto) {
        this.quantidade = quantidade;
        this.quantidadeMinima = quantidadeMinima;
        this.valorTotal = valorTotal;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.produto = produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Double quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public ProdutoDTORequest getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTORequest produto) {
        this.produto = produto;
    }
}
