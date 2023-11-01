package com.projeto.gerenciamentoAlimentos.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@RequiredArgsConstructor
public class ErrorResponse {
    private final String field;
    private final String message;
    private List<ValidationError> errors;

    @Data
    @RequiredArgsConstructor
    private static class ValidationError{
        private final String field;
        private final String message;
    }

    public void addValidationError(String field, String message){
        if (Objects.isNull(errors)){
            this.errors = new ArrayList<ValidationError>();
        }
        this.errors.add(new ValidationError(field, message));
    }

}
