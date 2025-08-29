package br.com.bean.controllers;

import br.com.bean.business.dto.ProductDto;
import br.com.bean.business.dto.ProductMinDto;
import br.com.bean.business.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductMinDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(params = "nameOrBarCode")
    public ResponseEntity<List<ProductDto>> findByNameOrBarCode(@RequestParam String nameOrBarCode) {
        return ResponseEntity.ok(service.findByNameOrBarCode(nameOrBarCode));
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(service.saveProduct(productDto));
    }
}
