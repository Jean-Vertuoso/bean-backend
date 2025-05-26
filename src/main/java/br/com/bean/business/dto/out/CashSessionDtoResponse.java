package br.com.bean.business.dto.out;

import java.math.BigDecimal;
import java.time.Instant;

public class CashSessionDtoResponse {

    private Long id;
    private Instant openingTimestamp;
    private Instant closingTimestamp;
    private BigDecimal openingAmount;
    private BigDecimal closingAmount;
    private BigDecimal expectedAmount;
    private String notes;
    private Boolean closed;
    private UserDtoResponse operator;

    public CashSessionDtoResponse() {
    }

    public CashSessionDtoResponse(Long id, Instant openingTimestamp, Instant closingTimestamp, BigDecimal openingAmount, BigDecimal closingAmount, BigDecimal expectedAmount, String notes, Boolean closed, UserDtoResponse operator) {
        this.id = id;
        this.openingTimestamp = openingTimestamp;
        this.closingTimestamp = closingTimestamp;
        this.openingAmount = openingAmount;
        this.closingAmount = closingAmount;
        this.expectedAmount = expectedAmount;
        this.notes = notes;
        this.closed = closed;
        this.operator = operator;
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

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public UserDtoResponse getOperator() {
        return operator;
    }

    public void setOperator(UserDtoResponse operator) {
        this.operator = operator;
    }
}
