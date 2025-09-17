package br.com.bean.controllers;

import br.com.bean.business.dto.SaleDto;
import br.com.bean.business.services.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService service;

    public SaleController(SaleService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findSaleWithItemsById(id));
    }

    @PostMapping
    public ResponseEntity<SaleDto> saveSale(@RequestBody SaleDto dto) {
        dto = service.saveSale(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
