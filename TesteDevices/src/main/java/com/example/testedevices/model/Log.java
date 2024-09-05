package com.example.testedevices.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity // Indica que esta classe é uma entidade JPA
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Gera automaticamente o valor do ID
    private UUID id;
    private String message;
    private LocalDateTime timestamp;

    @ManyToOne // Define o relacionamento muitos-para-um com a entidade Device
    @JoinColumn(name = "device_id") // Especifica a coluna de junção para o relacionamento
    private Device device;

    // Getters e Setters
    public UUID getId() {
        return id; // Retorna o ID do log
    }

    public String getMessage() {
        return message; // Retorna a mensagem do log
    }

    public LocalDateTime getTimestamp() {
        return timestamp; // Retorna o timestamp do log
    }

    public Device getDevice() {
        return device; // Retorna o dispositivo associado ao log
    }

    public void setId(UUID id) {
        this.id = id; // Define o ID do log
    }

    public void setMessage(String message) {
        this.message = message; // Define a mensagem do log
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp; // Define o timestamp do log
    }

    public void setDevice(Device device) {
        this.device = device; // Define o dispositivo associado ao log
    }
}
