package br.com.bean.controllers;

import br.com.bean.business.dto.CashSessionDto;
import br.com.bean.business.services.CashSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashSessions")
public class CashSessionController {

    private final CashSessionService service;

    public CashSessionController(CashSessionService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<CashSessionDto> openCashSession(){
        return ResponseEntity.ok(service.openCashSession());
    }
}
