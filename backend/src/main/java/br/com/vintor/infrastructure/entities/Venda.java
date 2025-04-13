package br.com.vintor.infrastructure.entities;

import br.com.vintor.infrastructure.entities.enums.FormaPagamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class Venda implements Serializable {

    private Long id;
    private Instant dataHoraVenda;
    private BigDecimal descontoTotal;
    private BigDecimal valorTotal;

    private Cliente cliente;
    private Usuario operador;
    private SessaoDeCaixa sessaoDeCaixa;
    private FormaPagamento formaPagamento;

    private List<ItemVenda> itens;

    public Venda() {
    }

    public Venda(Long id, Instant dataHoraVenda, BigDecimal descontoTotal, BigDecimal valorTotal, Cliente cliente, Usuario operador, SessaoDeCaixa sessaoDeCaixa, FormaPagamento formaPagamento) {
        this.id = id;
        this.dataHoraVenda = dataHoraVenda;
        this.descontoTotal = descontoTotal;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.operador = operador;
        this.sessaoDeCaixa = sessaoDeCaixa;
        this.formaPagamento = formaPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataHoraVenda() {
        return dataHoraVenda;
    }

    public void setDataHoraVenda(Instant dataHoraVenda) {
        this.dataHoraVenda = dataHoraVenda;
    }

    public BigDecimal getDescontoTotal() {
        return descontoTotal;
    }

    public void setDescontoTotal(BigDecimal descontoTotal) {
        this.descontoTotal = descontoTotal;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getOperador() {
        return operador;
    }

    public void setOperador(Usuario operador) {
        this.operador = operador;
    }

    public SessaoDeCaixa getSessaoDeCaixa() {
        return sessaoDeCaixa;
    }

    public void setSessaoDeCaixa(SessaoDeCaixa sessaoDeCaixa) {
        this.sessaoDeCaixa = sessaoDeCaixa;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
