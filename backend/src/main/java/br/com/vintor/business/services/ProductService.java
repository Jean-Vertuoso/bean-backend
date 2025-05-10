package br.com.vintor.business.services;

import br.com.vintor.business.converters.ProductConverter;
import br.com.vintor.business.dto.in.ProductDtoRequest;
import br.com.vintor.business.dto.out.ProductDtoResponse;
import br.com.vintor.infrastructure.entities.Product;
import br.com.vintor.infrastructure.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductConverter productConverter;

    public ProductService(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    public ProductDtoResponse saveProduct(ProductDtoRequest productDto){
        Product product = productConverter.toProductEntity(productDto);
        return productConverter.toProductDto(productRepository.save(product));
    }
}
