package br.com.bean.infrastructure.entities;

import br.com.bean.infrastructure.entities.pk.SaleItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_sale_item")
public class SaleItem {

    @EmbeddedId
    private SaleItemPK id = new SaleItemPK();

    private Double quantity;
    private BigDecimal unitPrice;
    private BigDecimal discount;

    public SaleItem() {
    }

    public SaleItem(Sale sale, Product product, Double quantity, BigDecimal unitPrice, BigDecimal discount) {
        id.setSale(sale);
        id.setProduct(product);
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    private Sale getOrder(){
        return id.getSale();
    }

    public void setOrder(Sale sale){
        id.setSale(sale);
    }

    private Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getSubTotal(){
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SaleItem saleItem = (SaleItem) o;
        return Objects.equals(id, saleItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
