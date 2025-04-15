package br.com.vintor.business.dto.in;

import java.math.BigDecimal;

public class ItemVendaDTORequest {

    private Long produtoId;
    private Double quantidade;
    private BigDecimal desconto;

    public ItemVendaDTORequest() {
    }

    public ItemVendaDTORequest(Long produtoId, Double quantidade, BigDecimal desconto) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }
}
