package br.com.vintor.infrastructure.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Estoque implements Serializable {

    private Long id;
    private Double quantidade;
    private Double quantidadeMinima;
    private BigDecimal valorTotal;
    private LocalDateTime ultimaAtualizacao;

    private Produto produto;

    public Estoque() {
    }

    public Estoque(Long id, Double quantidade, Double quantidadeMinima, BigDecimal valorTotal, LocalDateTime ultimaAtualizacao, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.quantidadeMinima = quantidadeMinima;
        this.valorTotal = valorTotal;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void atualizarValorTotal(){
        if(produto != null && produto.getPreco() != null && quantidade != null){
            this.valorTotal = produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
        } else {
            this.valorTotal = BigDecimal.ZERO;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return Objects.equals(id, estoque.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
