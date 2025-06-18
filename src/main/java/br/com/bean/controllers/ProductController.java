package br.com.bean.controllers;

import br.com.bean.business.dto.in.ProductDtoRequest;
import br.com.bean.business.dto.out.ProductDtoResponse;
import br.com.bean.business.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
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
