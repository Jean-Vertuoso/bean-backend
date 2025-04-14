package br.com.vintor.infrastructure.entities;

import br.com.vintor.infrastructure.entities.pk.ItemVendaPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_item_venda")
public class ItemVenda {

    @EmbeddedId
    private ItemVendaPK id = new ItemVendaPK();

    private Double quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal desconto;

    public ItemVenda() {
    }

    public ItemVenda(Venda venda, Produto produto, BigDecimal desconto, BigDecimal precoUnitario, Double quantidade) {
        id.setVenda(venda);
        id.setProduto(produto);
        this.desconto = desconto;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    private Venda getVenda(){
        return id.getVenda();
    }

    public void setVenda(Venda venda){
        id.setVenda(venda);
    }

    private Produto getProduto(){
        return id.getProduto();
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getSubTotal(){
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemVenda itemVenda = (ItemVenda) o;
        return Objects.equals(id, itemVenda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
