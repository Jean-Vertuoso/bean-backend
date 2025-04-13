package br.com.vintor.infrastructure.entities.pk;

import br.com.vintor.infrastructure.entities.Produto;
import br.com.vintor.infrastructure.entities.Venda;

import java.util.Objects;

public class ItemVendaPK {

    private Venda venda;
    private Produto produto;

    public ItemVendaPK() {
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemVendaPK that = (ItemVendaPK) o;
        return Objects.equals(venda, that.venda) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venda, produto);
    }
}
