package br.com.vintor.controllers;

import br.com.vintor.business.dto.in.ProductDtoRequest;
import br.com.vintor.business.dto.out.ProductDtoResponse;
import br.com.vintor.business.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDtoResponse> saveProduct(@RequestBody ProductDtoRequest productDto){
        return ResponseEntity.ok(productService.saveProduct(productDto));
    }
}
