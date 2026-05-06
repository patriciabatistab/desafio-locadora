package br.com.solutis.locadora.service;

import br.com.solutis.locadora.dto.FilmeRequestDTO;
import br.com.solutis.locadora.entity.Filme;
import br.com.solutis.locadora.exception.EntidadeCadastradaExcception;
import br.com.solutis.locadora.exception.EntidadeNaoEncontradaException;
import br.com.solutis.locadora.mapper.FilmeMapper;
import br.com.solutis.locadora.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository repository;

    public Filme cadastrar(FilmeRequestDTO dto){
        Filme filme = FilmeMapper.toFilme(dto);

            if (repository.existsByTituloIgnoreCaseAndDiretorIgnoreCase(filme.getTitulo(), filme.getDiretor())){
                throw new EntidadeCadastradaExcception("Filme com o mesmo titulo e diretor já cadastrado.");
            }

        return repository.save(filme);
    }

    public List<Filme> listar(){
         List<Filme> filmes = repository.findAll();
         return filmes;
    }
}
