package br.com.bean.controllers;

import br.com.bean.business.dto.SaleDto;
import br.com.bean.business.services.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService service;

    public SaleController(SaleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SaleDto> saveSale(@RequestBody SaleDto dto) {
        return ResponseEntity.ok(service.saveSale(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findSaleWithItemsById(id));
    }
}
