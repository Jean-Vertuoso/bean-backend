package br.com.bean.business.dto;

import java.math.BigDecimal;

public class SaleItemDto {

    private Long productId;
    private String name;
    private Double quantity;
    private BigDecimal price;
    private BigDecimal discount;
    private BigDecimal subtotal;

    public SaleItemDto() {
    }

    public SaleItemDto(Long productId, String name, Double quantity, BigDecimal price, BigDecimal subtotal, BigDecimal discount) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = subtotal;
        this.discount = discount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
