package br.com.bean.business.converters;

import br.com.bean.business.dto.CategoryDto;
import br.com.bean.business.dto.ProductDto;
import br.com.bean.infrastructure.entities.Category;
import br.com.bean.infrastructure.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private InventoryConverter inventoryConverter;

    public ProductConverter(InventoryConverter inventoryConverter) {
        this.inventoryConverter = inventoryConverter;
    }

    public Product dtoToEntity(ProductDto dto){
        Product entity = new Product();

        entity.setName(dto.getName());
        entity.setBrand(dto.getBrand());
        entity.setPrice(dto.getPrice());
        entity.setBarCode(dto.getBarCode());
        entity.setImgUrl(dto.getImgUrl());
        entity.setPackagingType(dto.getPackagingType());
        entity.setUnitOfMeasure(dto.getUnitOfMeasure());

        return entity;
    }

    public ProductDto entityToDto(Product entity) {
        ProductDto dto = new ProductDto();

        dto.setName(entity.getName());
        dto.setBrand(entity.getBrand());
        dto.setPrice(entity.getPrice());
        dto.setBarCode(entity.getBarCode());
        dto.setImgUrl(entity.getImgUrl());
        dto.setPackagingType(entity.getPackagingType());
        dto.setUnitOfMeasure(entity.getUnitOfMeasure());

        return dto;
    }

    public Category categoryDtoToEntity(CategoryDto dto){
        Category entity = new Category();

        entity.setName(dto.getName());

        return entity;
    }
}
