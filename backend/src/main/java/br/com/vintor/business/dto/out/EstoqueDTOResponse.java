package br.com.vintor.business.dto.out;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EstoqueDTOResponse {

    private Double quantidade;
    private Double quantidadeMinima;
    private BigDecimal valorTotal;
    private LocalDateTime ultimaAtualizacao;

    private ProdutoDTOResponse produto;

    public EstoqueDTOResponse() {
    }

    public EstoqueDTOResponse(Double quantidade, Double quantidadeMinima, BigDecimal valorTotal, LocalDateTime ultimaAtualizacao, ProdutoDTOResponse produto) {
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

    public ProdutoDTOResponse getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTOResponse produto) {
        this.produto = produto;
    }
}
