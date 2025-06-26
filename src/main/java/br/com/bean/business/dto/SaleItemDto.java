package br.com.bean.business.dto;

import java.math.BigDecimal;

public class SaleItemDto {

    private Long productId;
    private Double quantity;
    private BigDecimal discount;

    public SaleItemDto() {
    }

    public SaleItemDto(Long productId, Double quantity, BigDecimal discount) {
        this.productId = productId;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
