package br.com.solutis.locadora.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LocacaoResponseDTO {
    private Long id;
    private Cliente cliente;
    private Filme filme;
    private LocalDate dataLocacao ;
    private boolean devolvido;

    @Getter
    @Setter
    public static class Cliente{
        private Long id;
        private String nome;
        private String email;
    }

    @Getter
    @Setter
    public static class Filme{
        private Long id;
        private String titulo;
        private String genero;
    }
}
