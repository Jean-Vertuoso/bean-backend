package br.com.bean.business.converters;

import br.com.bean.business.dto.CategoryDto;
import br.com.bean.business.dto.in.ProductDtoRequest;
import br.com.bean.business.dto.out.ProductDtoResponse;
import br.com.bean.infrastructure.entities.Category;
import br.com.bean.infrastructure.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private InventoryConverter inventoryConverter;

    public ProductConverter(InventoryConverter inventoryConverter) {
        this.inventoryConverter = inventoryConverter;
    }

    public Product toProductEntity(ProductDtoRequest productDto){
        Product product = new Product();

        product.setName(productDto.getName());
        product.setBrand(productDto.getBrand());
        product.setPrice(productDto.getPrice());
        product.setBarCode(productDto.getBarCode());
        product.setImgUrl(productDto.getImgUrl());
        product.setPackagingType(productDto.getPackagingType());
        product.setUnitOfMeasure(productDto.getUnitOfMeasure());
        product.setInventory(inventoryConverter.toInventoryEntity(productDto.getInventory()));

        return product;
    }

    public ProductDtoResponse toProductDto(Product product) {
        ProductDtoResponse productDto = new ProductDtoResponse();

        productDto.setName(product.getName());
        productDto.setBrand(product.getBrand());
        productDto.setPrice(product.getPrice());
        productDto.setBarCode(product.getBarCode());
        productDto.setImgUrl(product.getImgUrl());
        productDto.setPackagingType(product.getPackagingType());
        productDto.setUnitOfMeasure(product.getUnitOfMeasure());
        productDto.setInventory(inventoryConverter.toInventoryDto(product.getInventory()));

        return productDto;
    }

    public Category toCategoryEntity(CategoryDto categoryDto){
        Category category = new Category();

        category.setName(category.getName());

        return category;
    }
}
