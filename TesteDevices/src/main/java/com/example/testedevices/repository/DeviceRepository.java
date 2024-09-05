package com.example.testedevices.repository;

import com.example.testedevices.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    <T> Optional<T> findById(UUID id); // Método para encontrar um dispositivo pelo ID, retornando um Optional
}
