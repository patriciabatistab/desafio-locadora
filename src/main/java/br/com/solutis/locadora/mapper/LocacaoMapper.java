package br.com.solutis.locadora.mapper;

import br.com.solutis.locadora.dto.LocacaoResponseDTO;
import br.com.solutis.locadora.entity.Cliente;
import br.com.solutis.locadora.entity.Filme;
import br.com.solutis.locadora.entity.Locacao;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LocacaoMapper {

    public static Locacao toEntity(Cliente cliente, Filme filme){
        Locacao locacao = new Locacao();

        locacao.setCliente(cliente);
        locacao.setFilme(filme);
        locacao.setDataLocacao(LocalDate.now());

        return locacao;
    }

    public static LocacaoResponseDTO toResponse(Locacao locacao){
        LocacaoResponseDTO dto = new LocacaoResponseDTO();

        LocacaoResponseDTO.Cliente clienteDto = new LocacaoResponseDTO.Cliente();

        clienteDto.setId(locacao.getCliente().getId());
        clienteDto.setNome(locacao.getCliente().getNome());
        clienteDto.setEmail(locacao.getCliente().getEmail());

        dto.setCliente(clienteDto);

        LocacaoResponseDTO.Filme filmeDto = new LocacaoResponseDTO.Filme();

        filmeDto.setId(locacao.getFilme().getId());
        filmeDto.setTitulo(locacao.getFilme().getTitulo());
        filmeDto.setGenero(locacao.getFilme().getGenero());

        dto.setId(locacao.getId());
        dto.setFilme(filmeDto);
        dto.setDataLocacao(locacao.getDataLocacao());
        dto.setDevolvido(locacao.isDevolvido());

        return dto;
    }
}
