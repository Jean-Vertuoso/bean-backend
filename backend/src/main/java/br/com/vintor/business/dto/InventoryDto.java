package br.com.vintor.business.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InventoryDto {

    private Double quantity;
    private Double minimumQuantity;
    private BigDecimal totalValue;
    private LocalDateTime lastUpdated;

    public InventoryDto() {
    }

    public InventoryDto(Double quantity, Double minimumQuantity, BigDecimal totalValue, LocalDateTime lastUpdated) {
        this.quantity = quantity;
        this.minimumQuantity = minimumQuantity;
        this.totalValue = totalValue;
        this.lastUpdated = lastUpdated;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Double minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
