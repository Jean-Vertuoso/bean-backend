package br.com.bean.controllers;

import br.com.bean.business.dto.in.ClientDtoRequest;
import br.com.bean.business.dto.out.ClientDtoResponse;
import br.com.bean.business.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDtoResponse> saveClient(@RequestBody ClientDtoRequest dto){
        return ResponseEntity.ok(clientService.saveClient(dto));
    }
}
