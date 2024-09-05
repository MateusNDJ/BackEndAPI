package com.example.testedevices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) // Define o status HTTP como 404 Not Found quando a exceção é lançada
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message); // Chama o construtor da superclasse com a mensagem fornecida
    }
}
