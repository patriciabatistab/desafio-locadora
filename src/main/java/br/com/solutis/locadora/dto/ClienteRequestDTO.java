package br.com.solutis.locadora.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class ClienteRequestDTO {
    @NotBlank(message = "Nome não pode estar vazio.")
    private String nome;

    @NotBlank(message = "Email não pode estar vazio.")
    @Pattern(regexp = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$", message = "Email não está no padrão aceito.")
    private String email;
}
