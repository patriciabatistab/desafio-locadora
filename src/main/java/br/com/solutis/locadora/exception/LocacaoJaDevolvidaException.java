package br.com.solutis.locadora.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class LocacaoJaDevolvidaException extends RuntimeException {
    public LocacaoJaDevolvidaException(String message) {
        super(message);
    }
}
