package br.com.bean.infrastructure.entities;

import br.com.bean.business.enums.PackagingType;
import br.com.bean.business.enums.UnitOfMeasure;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String name;
    private String brand;
    private BigDecimal price;
    private String barCode;
    private String imgUrl;

    @Enumerated(EnumType.STRING)
    private PackagingType packagingType;

    @Enumerated(EnumType.STRING)
    private UnitOfMeasure unitOfMeasure;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Inventory inventory;

    @ManyToMany
    @JoinTable(name = "tb_product_category",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private Set<SaleItem> items = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name, String brand, BigDecimal price, String barCode, String imgUrl, PackagingType packagingType, UnitOfMeasure unitOfMeasure, Inventory inventory) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.barCode = barCode;
        this.imgUrl = imgUrl;
        this.packagingType = packagingType;
        this.unitOfMeasure = unitOfMeasure;
        this.inventory = inventory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Set<SaleItem> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
