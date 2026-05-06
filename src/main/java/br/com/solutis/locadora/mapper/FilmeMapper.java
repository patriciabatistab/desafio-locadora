package br.com.solutis.locadora.mapper;

import br.com.solutis.locadora.dto.FilmeRequestDTO;
import br.com.solutis.locadora.entity.Filme;
import org.springframework.stereotype.Component;

@Component
public class FilmeMapper {

    public static Filme toFilme(FilmeRequestDTO dto){
        Filme filme = new Filme();

        filme.setTitulo(dto.getTitulo());
        filme.setGenero(dto.getGenero());
        filme.setDiretor(dto.getDiretor());

        return filme;
    }
}
