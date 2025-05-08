package br.com.vintor.business.dto.out;

import br.com.vintor.business.enums.PaymentMethod;

import java.math.BigDecimal;
import java.time.Instant;

public class SaleDtoResponse {

    private Long id;
    private Instant saleTimestamp;
    private BigDecimal totalDiscount;
    private BigDecimal totalValue;
    private PaymentMethod paymentMethod;
    private ClientDtoResponse client;
    private CashSessionDtoResponse cashSession;
    private UserDtoResponse operator;

    public SaleDtoResponse() {
    }

    public SaleDtoResponse(Long id, Instant saleTimestamp, BigDecimal totalDiscount, BigDecimal totalValue, PaymentMethod paymentMethod, ClientDtoResponse client, CashSessionDtoResponse cashSession, UserDtoResponse operator) {
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

    public ClientDtoResponse getClient() {
        return client;
    }

    public void setClient(ClientDtoResponse client) {
        this.client = client;
    }

    public CashSessionDtoResponse getCashSession() {
        return cashSession;
    }

    public void setCashSession(CashSessionDtoResponse cashSession) {
        this.cashSession = cashSession;
    }

    public UserDtoResponse getOperator() {
        return operator;
    }

    public void setOperator(UserDtoResponse operator) {
        this.operator = operator;
    }
}