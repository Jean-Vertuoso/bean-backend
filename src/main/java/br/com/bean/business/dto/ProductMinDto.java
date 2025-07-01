package br.com.bean.business.dto;

import java.math.BigDecimal;

public class ProductMinDto {

    private String brand;
    private String name;
    private BigDecimal price;
    private String imgUrl;

    public ProductMinDto() {
    }

    public ProductMinDto(String brand, String name, BigDecimal price, String imgUrl) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
