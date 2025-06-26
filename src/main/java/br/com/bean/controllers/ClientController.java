package br.com.bean.controllers;

import br.com.bean.business.dto.ClientDto;
import br.com.bean.business.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto dto){
        return ResponseEntity.ok(service.saveClient(dto));
    }
}
