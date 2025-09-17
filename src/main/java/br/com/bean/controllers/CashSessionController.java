package br.com.bean.controllers;

import br.com.bean.business.dto.CashSessionDto;
import br.com.bean.business.dto.ClosingSessionDto;
import br.com.bean.business.services.CashSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cashSessions")
public class CashSessionController {

    private final CashSessionService service;

    public CashSessionController(CashSessionService service) {
        this.service = service;
    }

    @GetMapping("/active")
    public ResponseEntity<Long> getActiveCashSession() {
        return ResponseEntity.ok(service.getActiveCashSession());
    }

    @PostMapping("/open")
    public ResponseEntity<CashSessionDto> openCashSession(){
        CashSessionDto dto = service.openCashSession();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping("/close")
    public ResponseEntity<CashSessionDto> closeCashSession(@RequestBody ClosingSessionDto dto){
        return ResponseEntity.ok(service.closeCashSession(dto));
    }
}
