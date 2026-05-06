package br.com.solutis.locadora.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntidadeCadastradaExcception extends RuntimeException {
    public EntidadeCadastradaExcception(String message) {
        super(message);
    }
}
