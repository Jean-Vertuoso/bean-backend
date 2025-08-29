package br.com.bean.controllers;

import br.com.bean.business.services.ConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/configs")
public class ConfigController {

    private final ConfigService service;

    public ConfigController(ConfigService service) {
        this.service = service;
    }

    @PutMapping("/cash-opening-amount")
    public ResponseEntity<Void> updateOpeningAmount(@RequestParam BigDecimal amount) {
        service.updateDefaultOpeningAmount(amount);
        return ResponseEntity.noContent().build();
    }
}
