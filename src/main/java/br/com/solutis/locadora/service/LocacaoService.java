package br.com.solutis.locadora.service;

import br.com.solutis.locadora.dto.LocacaoResponseDTO;
import br.com.solutis.locadora.entity.Cliente;
import br.com.solutis.locadora.entity.Filme;
import br.com.solutis.locadora.entity.Locacao;
import br.com.solutis.locadora.exception.EntidadeNaoEncontradaException;
import br.com.solutis.locadora.exception.FilmeAlugadoException;
import br.com.solutis.locadora.exception.LocacaoJaDevolvidaException;
import br.com.solutis.locadora.mapper.LocacaoMapper;
import br.com.solutis.locadora.repository.ClienteRepository;
import br.com.solutis.locadora.repository.FilmeRepository;
import br.com.solutis.locadora.repository.LocacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocacaoService {

    private final LocacaoRepository locacaoRepository;
    private final ClienteRepository clienteRepository;
    private final FilmeRepository filmeRepository;

    public LocacaoResponseDTO alugar(Long idCliente, Long idFilme){
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente não encontrado."));
        Filme filme = filmeRepository.findById(idFilme).orElseThrow(() -> new EntidadeNaoEncontradaException("Filme não encontrado."));
        Locacao locacao = LocacaoMapper.toEntity(cliente, filme);
        if (locacaoRepository.existsByFilmeIdAndDevolvidoFalse(locacao.getFilme().getId())){
            throw new FilmeAlugadoException("Filme escolhido já está alugado.");
        }
        return LocacaoMapper.toResponse(locacaoRepository.save(locacao));
    }

    public LocacaoResponseDTO devolucao(Long id){
        Locacao locacao = locacaoRepository.findById(id).orElse(null);
            if (locacao == null) {
                throw new EntidadeNaoEncontradaException("Locação não encontrada.");
            }

            if (locacao.isDevolvido()){
                throw new LocacaoJaDevolvidaException("O filme desta locação já foi devolvido.");
            }

            locacao.setDataDevolucao(LocalDate.now());
            locacao.setDevolvido(true);

            return LocacaoMapper.toResponse(locacaoRepository.save(locacao));
    }

    public List<LocacaoResponseDTO> listar(){
        return locacaoRepository.findAll().stream().map(LocacaoMapper::toResponse).toList();
    }
}
