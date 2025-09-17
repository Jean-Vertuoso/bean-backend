package br.com.bean.business.dto;

import java.math.BigDecimal;

public class ClosingSessionDto {

    private BigDecimal closingAmount;
    private String notes;

    public ClosingSessionDto() {
    }

    public ClosingSessionDto(BigDecimal closingAmount, String notes) {
        this.closingAmount = closingAmount;
        this.notes = notes;
    }

    public BigDecimal getClosingAmount() {
        return closingAmount;
    }

    public void setClosingAmount(BigDecimal closingAmount) {
        this.closingAmount = closingAmount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
