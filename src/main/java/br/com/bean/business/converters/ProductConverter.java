package br.com.bean.business.converters;

import br.com.bean.business.dto.CategoryDto;
import br.com.bean.business.dto.ProductDto;
import br.com.bean.business.dto.ProductMinDto;
import br.com.bean.infrastructure.entities.Category;
import br.com.bean.infrastructure.entities.Product;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDto dto, Set<Category> categories){
        Product entity = new Product();

        entity.setName(dto.getName());
        entity.setBrand(dto.getBrand());
        entity.setPrice(dto.getPrice());
        entity.setBarCode(dto.getBarCode());
        entity.setImgUrl(dto.getImgUrl());
        entity.setPackagingType(dto.getPackagingType());
        entity.setUnitOfMeasure(dto.getUnitOfMeasure());
        categories.forEach(entity::addCategory);

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

    public ProductMinDto entityToMinDto(Product entity){
        ProductMinDto minDto = new ProductMinDto();

        minDto.setBrand(entity.getBrand());
        minDto.setName(entity.getName());
        minDto.setPrice(entity.getPrice());
        minDto.setImgUrl(entity.getImgUrl());

        return minDto;
    }

    public Category categoryDtoToEntity(CategoryDto dto){
        Category entity = new Category();

        entity.setName(dto.getName());

        return entity;
    }
}
