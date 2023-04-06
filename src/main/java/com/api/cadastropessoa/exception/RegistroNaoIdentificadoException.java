package com.api.cadastropessoa.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RegistroNaoIdentificadoException extends EntityNotFoundException {
    public RegistroNaoIdentificadoException(final Long id) {
        super(String.format("Registro %s não identificado", id));
    }
}
