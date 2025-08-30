package br.com.bean.business.dto;

import br.com.bean.business.enums.PaymentMethod;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SaleDto {

    private Long id;
    private Instant saleTimestamp;
    private BigDecimal totalDiscount;
    private BigDecimal totalValue;
    private PaymentMethod paymentMethod;
    private Long clientId;
    private Long cashSessionId;
    private Long userId;
    private List<SaleItemDto> items = new ArrayList<>();

    public SaleDto() {
    }

    public SaleDto(Long id, Instant saleTimestamp, BigDecimal totalDiscount, BigDecimal totalValue, PaymentMethod paymentMethod, Long clientId, Long cashSessionId, Long userId) {
        this.id = id;
        this.saleTimestamp = saleTimestamp;
        this.totalDiscount = totalDiscount;
        this.totalValue = totalValue;
        this.paymentMethod = paymentMethod;
        this.clientId = clientId;
        this.cashSessionId = cashSessionId;
        this.userId = userId;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCashSessionId() {
        return cashSessionId;
    }

    public void setCashSessionId(Long cashSessionId) {
        this.cashSessionId = cashSessionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<SaleItemDto> getItems() {
        return items;
    }
}