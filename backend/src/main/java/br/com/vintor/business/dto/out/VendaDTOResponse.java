package br.com.vintor.business.dto.out;

import br.com.vintor.business.enums.FormaPagamento;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class VendaDTOResponse {

    private Instant dataHoraVenda;
    private BigDecimal descontoTotal;
    private BigDecimal valorTotal;

    private FormaPagamento formaPagamento;

    private ClienteDTOResponse cliente;

    private SessaoDeCaixaDTOResponse sessaoDeCaixa;

    private UsuarioDTOResponse operador;

    private Set<ItemVendaDTOResponse> itens = new HashSet<>();

    public VendaDTOResponse() {
    }

    public VendaDTOResponse(Instant dataHoraVenda, BigDecimal descontoTotal, BigDecimal valorTotal, FormaPagamento formaPagamento, ClienteDTOResponse cliente, SessaoDeCaixaDTOResponse sessaoDeCaixa, UsuarioDTOResponse operador) {
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

    public ClienteDTOResponse getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTOResponse cliente) {
        this.cliente = cliente;
    }

    public SessaoDeCaixaDTOResponse getSessaoDeCaixa() {
        return sessaoDeCaixa;
    }

    public void setSessaoDeCaixa(SessaoDeCaixaDTOResponse sessaoDeCaixa) {
        this.sessaoDeCaixa = sessaoDeCaixa;
    }

    public UsuarioDTOResponse getOperador() {
        return operador;
    }

    public void setOperador(UsuarioDTOResponse operador) {
        this.operador = operador;
    }

    public Set<ItemVendaDTOResponse> getItens() {
        return itens;
    }
}
