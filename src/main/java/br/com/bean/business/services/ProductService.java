package br.com.bean.business.services;

import br.com.bean.business.converters.ProductConverter;
import br.com.bean.business.dto.ProductDto;
import br.com.bean.business.dto.ProductMinDto;
import br.com.bean.infrastructure.entities.Category;
import br.com.bean.infrastructure.entities.Product;
import br.com.bean.infrastructure.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductConverter converter;
    private final CategoryService categoryService;

    public ProductService(ProductRepository repository, ProductConverter converter, CategoryService categoryService) {
        this.repository = repository;
        this.converter = converter;
        this.categoryService = categoryService;
    }

    @Transactional(readOnly = true)
    public List<ProductMinDto> findAll(){
        return repository.findAll().stream().map(converter::entityToMinDto).toList();
    }

    @Transactional
    public ProductDto saveProduct(ProductDto dto){
        Set<Category> categories = categoryService.findSetById(dto.getCategoryIds());
        Product entity = converter.dtoToEntity(dto, categories);
        return converter.entityToDto(repository.save(entity));
    }
}
