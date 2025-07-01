package br.com.bean.business.converters;

import br.com.bean.business.dto.CategoryDto;
import br.com.bean.infrastructure.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public Category toEntity(CategoryDto dto){
        return new Category(
                null,
                dto.getName()
        );
    }

    public CategoryDto toDto(Category entity){
        return new CategoryDto(
                entity.getId(),
                entity.getName()
        );
    }
}
