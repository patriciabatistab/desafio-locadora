package br.com.solutis.locadora.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class FilmeRequestDTO {
    @NotBlank(message = "Título não pode estar vazio.")
    private String titulo;
    @NotBlank(message = "Gênero não pode estar vazio.")
    private String genero;
    @NotBlank(message = "Diretor não pode estar vazio.")
    private String diretor;
}
