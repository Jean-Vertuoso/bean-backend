package br.com.bean.controllers;

import br.com.bean.business.dto.ClientDto;
import br.com.bean.business.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<ClientDto>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @PostMapping
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto dto){
        dto = service.saveClient(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
