package br.com.bean.infrastructure.entities;

import br.com.bean.infrastructure.entities.pk.SaleItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Entity
@Table(name = "tb_sale_item")
public class SaleItem {

    @EmbeddedId
    private SaleItemPK id = new SaleItemPK();

    private Double quantity;
    private BigDecimal price;
    private BigDecimal discount;
    private BigDecimal subtotal;

    public SaleItem() {
    }

    public SaleItem(Sale sale, Product product, Double quantity, BigDecimal price, BigDecimal discount) {
        id.setSale(sale);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.calcSubtotal();
    }

    public Sale getOrder(){
        return id.getSale();
    }

    public void setOrder(Sale sale){
        id.setSale(sale);
    }

    public Product getProduct(){
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

    public void calcSubtotal() {
        subtotal = price.multiply(BigDecimal.valueOf(quantity))
                .subtract(discount)
                .setScale(2, RoundingMode.HALF_UP);
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
