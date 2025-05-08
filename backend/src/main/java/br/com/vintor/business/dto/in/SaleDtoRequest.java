package br.com.vintor.business.dto.in;

import br.com.vintor.business.enums.PaymentMethod;
import br.com.vintor.infrastructure.entities.CashSession;
import br.com.vintor.infrastructure.entities.Client;
import br.com.vintor.infrastructure.entities.User;

import java.math.BigDecimal;
import java.time.Instant;

public class SaleDtoRequest {

    private Long id;
    private Instant saleTimestamp;
    private BigDecimal totalDiscount;
    private BigDecimal totalValue;
    private PaymentMethod paymentMethod;
    private ClientDtoRequest client;
    private CashSessionDtoRequest cashSession;
    private UserDtoRequest operator;

    public SaleDtoRequest() {
    }

    public SaleDtoRequest(Long id, Instant saleTimestamp, BigDecimal totalDiscount, BigDecimal totalValue, PaymentMethod paymentMethod, ClientDtoRequest client, CashSessionDtoRequest cashSession, UserDtoRequest operator) {
        this.id = id;
        this.saleTimestamp = saleTimestamp;
        this.totalDiscount = totalDiscount;
        this.totalValue = totalValue;
        this.paymentMethod = paymentMethod;
        this.client = client;
        this.cashSession = cashSession;
        this.operator = operator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getSaleTimestamp() {
        return saleTimestamp;
    }

    public void setSaleTimestamp(Instant saleTimestamp) {
        this.saleTimestamp = saleTimestamp;
    }

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(BigDecimal totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ClientDtoRequest getClient() {
        return client;
    }

    public void setClient(ClientDtoRequest client) {
        this.client = client;
    }

    public CashSessionDtoRequest getCashSession() {
        return cashSession;
    }

    public void setCashSession(CashSessionDtoRequest cashSession) {
        this.cashSession = cashSession;
    }

    public UserDtoRequest getOperator() {
        return operator;
    }

    public void setOperator(UserDtoRequest operator) {
        this.operator = operator;
    }
}