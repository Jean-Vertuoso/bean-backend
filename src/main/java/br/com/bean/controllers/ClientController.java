package br.com.bean.controllers;

import br.com.bean.business.dto.ClientDto;
import br.com.bean.business.dto.ClientMinDto;
import br.com.bean.business.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto dto){
        return ResponseEntity.ok(service.saveClient(dto));
    }
}
