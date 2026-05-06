package br.com.solutis.locadora.controller;

import br.com.solutis.locadora.dto.LocacaoResponseDTO;
import br.com.solutis.locadora.entity.Cliente;
import br.com.solutis.locadora.entity.Filme;
import br.com.solutis.locadora.entity.Locacao;
import br.com.solutis.locadora.mapper.LocacaoMapper;
import br.com.solutis.locadora.service.ClienteService;
import br.com.solutis.locadora.service.FilmeService;
import br.com.solutis.locadora.service.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacoes")
@RequiredArgsConstructor
public class LocacaoController {

    private final LocacaoService locacaoService;

    @GetMapping
    public ResponseEntity<List<LocacaoResponseDTO>> listar(){
        return ResponseEntity.ok(locacaoService.listar());
    }

    @PostMapping
    public ResponseEntity<LocacaoResponseDTO> alugar(Long idCliente, Long idFilme){
        return ResponseEntity.created(null).body(locacaoService.alugar(idCliente, idFilme));
    }

    @PutMapping("/{id}/devolucao")
    public ResponseEntity<LocacaoResponseDTO> devolucao(@PathVariable Long id){
        return ResponseEntity.ok(locacaoService.devolucao(id));
    }
}
