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

    public Product dtoToEntity(ProductDtoRequest dto){
        Product entity = new Product();

        entity.setName(dto.getName());
        entity.setBrand(dto.getBrand());
        entity.setPrice(dto.getPrice());
        entity.setBarCode(dto.getBarCode());
        entity.setImgUrl(dto.getImgUrl());
        entity.setPackagingType(dto.getPackagingType());
        entity.setUnitOfMeasure(dto.getUnitOfMeasure());
        entity.setInventory(inventoryConverter.dtoToEntity(dto.getInventory()));

        return entity;
    }

    public ProductDtoResponse entityToDto(Product entity) {
        ProductDtoResponse dto = new ProductDtoResponse();

        dto.setName(entity.getName());
        dto.setBrand(entity.getBrand());
        dto.setPrice(entity.getPrice());
        dto.setBarCode(entity.getBarCode());
        dto.setImgUrl(entity.getImgUrl());
        dto.setPackagingType(entity.getPackagingType());
        dto.setUnitOfMeasure(entity.getUnitOfMeasure());
        dto.setInventory(inventoryConverter.entityToDto(entity.getInventory()));

        return dto;
    }

    public Category categoryDtoToEntity(CategoryDto dto){
        Category entity = new Category();

        entity.setName(dto.getName());

        return entity;
    }
}
