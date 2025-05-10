package br.com.vintor.business.dto.in;

import br.com.vintor.business.dto.InventoryDto;
import br.com.vintor.business.enums.PackagingType;
import br.com.vintor.business.enums.UnitOfMeasure;

import java.math.BigDecimal;

public class ProductDtoRequest {

    private String name;
    private String brand;
    private BigDecimal price;
    private String barCode;
    private String imgUrl;
    private PackagingType packagingType;
    private UnitOfMeasure unitOfMeasure;
    private InventoryDto inventory;

    public ProductDtoRequest() {
    }

    public ProductDtoRequest(String name, String brand, BigDecimal price, String barCode, String imgUrl, PackagingType packagingType, UnitOfMeasure unitOfMeasure, InventoryDto inventory) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.barCode = barCode;
        this.imgUrl = imgUrl;
        this.packagingType = packagingType;
        this.unitOfMeasure = unitOfMeasure;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public PackagingType getPackagingType() {
        return packagingType;
    }

    public void setPackagingType(PackagingType packagingType) {
        this.packagingType = packagingType;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public InventoryDto getInventory() {
        return inventory;
    }

    public void setInventory(InventoryDto inventory) {
        this.inventory = inventory;
    }
}
