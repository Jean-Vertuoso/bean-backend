package br.com.bean.business.dto;

import br.com.bean.business.enums.PaymentMethod;

import java.math.BigDecimal;
import java.time.Instant;

public class SaleDto {

    private Long id;
    private Instant saleTimestamp;
    private BigDecimal totalDiscount;
    private BigDecimal totalValue;
    private PaymentMethod paymentMethod;
    private ClientDto client;
    private CashSessionDto cashSession;
    private UserDto operator;

    public SaleDto() {
    }

    public SaleDto(Long id, Instant saleTimestamp, BigDecimal totalDiscount, BigDecimal totalValue, PaymentMethod paymentMethod, ClientDto client, CashSessionDto cashSession, UserDto operator) {
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

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public CashSessionDto getCashSession() {
        return cashSession;
    }

    public void setCashSession(CashSessionDto cashSession) {
        this.cashSession = cashSession;
    }

    public UserDto getOperator() {
        return operator;
    }

    public void setOperator(UserDto operator) {
        this.operator = operator;
    }
}