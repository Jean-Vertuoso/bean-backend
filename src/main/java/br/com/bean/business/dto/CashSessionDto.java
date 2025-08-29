package br.com.bean.business.dto;

import br.com.bean.business.enums.CashSessionStatus;

import java.math.BigDecimal;
import java.time.Instant;

public class CashSessionDto {

    private Long id;
    private Instant openingTimestamp;
    private Instant closingTimestamp;
    private BigDecimal openingAmount;
    private BigDecimal closingAmount;
    private BigDecimal expectedAmount;
    private String notes;
    private CashSessionStatus status;
    private Long userId;

    public CashSessionDto() {
    }

    public CashSessionDto(Long id, Instant openingTimestamp, Instant closingTimestamp, BigDecimal openingAmount, BigDecimal closingAmount, BigDecimal expectedAmount, String notes, CashSessionStatus status, Long userId) {
        this.id = id;
        this.openingTimestamp = openingTimestamp;
        this.closingTimestamp = closingTimestamp;
        this.openingAmount = openingAmount;
        this.closingAmount = closingAmount;
        this.expectedAmount = expectedAmount;
        this.notes = notes;
        this.status = status;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getOpeningTimestamp() {
        return openingTimestamp;
    }

    public void setOpeningTimestamp(Instant openingTimestamp) {
        this.openingTimestamp = openingTimestamp;
    }

    public Instant getClosingTimestamp() {
        return closingTimestamp;
    }

    public void setClosingTimestamp(Instant closingTimestamp) {
        this.closingTimestamp = closingTimestamp;
    }

    public BigDecimal getOpeningAmount() {
        return openingAmount;
    }

    public void setOpeningAmount(BigDecimal openingAmount) {
        this.openingAmount = openingAmount;
    }

    public BigDecimal getClosingAmount() {
        return closingAmount;
    }

    public void setClosingAmount(BigDecimal closingAmount) {
        this.closingAmount = closingAmount;
    }

    public BigDecimal getExpectedAmount() {
        return expectedAmount;
    }

    public void setExpectedAmount(BigDecimal expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public CashSessionStatus getStatus() {
        return status;
    }

    public void setStatus(CashSessionStatus status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
