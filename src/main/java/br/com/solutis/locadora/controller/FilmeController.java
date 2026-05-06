package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.dto.FilmeRequestDTO;
import br.com.solutis.locadora.entity.Filme;
import br.com.solutis.locadora.service.FilmeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService service;

    @GetMapping
    public ResponseEntity<List<Filme>> listar(){
        return ResponseEntity.ok().body(service.listar());
    }

    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody @Valid FilmeRequestDTO dto){
        return ResponseEntity.created(null).body(service.cadastrar(dto));
    }
}
