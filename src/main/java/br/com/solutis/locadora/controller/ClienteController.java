package br.com.solutis.locadora.controller;


import br.com.solutis.locadora.dto.ClienteRequestDTO;
import br.com.solutis.locadora.entity.Cliente;
import br.com.solutis.locadora.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid ClienteRequestDTO dto){
        return ResponseEntity.created(null).body(service.cadastrar(dto));
    }
}
