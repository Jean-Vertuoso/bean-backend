package br.com.vintor.business.dto.in;

import br.com.vintor.infrastructure.entities.enums.FormaPagamento;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class VendaDTORequest {

    private Instant dataHoraVenda;
    private BigDecimal descontoTotal;
    private BigDecimal valorTotal;

    private FormaPagamento formaPagamento;

    private ClienteDTORequest cliente;

    private SessaoDeCaixaDTORequest sessaoDeCaixa;

    private UsuarioDTORequest operador;

    private Set<ItemVendaDTORequest> itens = new HashSet<>();

    public VendaDTORequest() {
    }

    public VendaDTORequest(Instant dataHoraVenda, BigDecimal descontoTotal, BigDecimal valorTotal, FormaPagamento formaPagamento, ClienteDTORequest cliente, SessaoDeCaixaDTORequest sessaoDeCaixa, UsuarioDTORequest operador) {
        this.dataHoraVenda = dataHoraVenda;
        this.descontoTotal = descontoTotal;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
        this.sessaoDeCaixa = sessaoDeCaixa;
        this.operador = operador;
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

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public ClienteDTORequest getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTORequest cliente) {
        this.cliente = cliente;
    }

    public SessaoDeCaixaDTORequest getSessaoDeCaixa() {
        return sessaoDeCaixa;
    }

    public void setSessaoDeCaixa(SessaoDeCaixaDTORequest sessaoDeCaixa) {
        this.sessaoDeCaixa = sessaoDeCaixa;
    }

    public UsuarioDTORequest getOperador() {
        return operador;
    }

    public void setOperador(UsuarioDTORequest operador) {
        this.operador = operador;
    }

    public Set<ItemVendaDTORequest> getItens() {
        return itens;
    }
}
