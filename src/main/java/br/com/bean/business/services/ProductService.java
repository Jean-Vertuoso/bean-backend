package br.com.bean.business.services;

import br.com.bean.business.converters.ProductConverter;
import br.com.bean.business.dto.ProductDto;
import br.com.bean.infrastructure.entities.Product;
import br.com.bean.infrastructure.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductConverter converter;

    public ProductService(ProductRepository repository, ProductConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Transactional
    public ProductDto saveProduct(ProductDto dto){
        Product entity = converter.dtoToEntity(dto);
        return converter.entityToDto(repository.save(entity));
    }
}
