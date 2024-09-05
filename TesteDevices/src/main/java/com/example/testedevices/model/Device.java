package com.example.testedevices.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity // Indica que esta classe é uma entidade JPA
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Gera automaticamente o valor do ID
    private UUID id;
    private String name;
    private String status;
    private LocalDateTime lastPing;
    private String location;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL) // Define o relacionamento um-para-muitos com a entidade Log
    private List<Log> logs;

    // Getters
    public String getName() {
        return name; // Retorna o nome do dispositivo
    }

    public String getStatus() {
        return status; // Retorna o status do dispositivo
    }

    public LocalDateTime getLastPing() {
        return lastPing; // Retorna o último ping do dispositivo
    }

    public String getLocation() {
        return location; // Retorna a localização do dispositivo
    }

    // Setters
    public void setName(String name) {
        this.name = name; // Define o nome do dispositivo
    }

    public void setStatus(String status) {
        this.status = status; // Define o status do dispositivo
    }

    public void setLastPing(LocalDateTime lastPing) {
        this.lastPing = lastPing; // Define o último ping do dispositivo
    }

    public void setLocation(String location) {
        this.location = location; // Define a localização do dispositivo
    }
}
