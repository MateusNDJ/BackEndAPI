package com.example.testedevices.controller;

import com.example.testedevices.model.Device;
import com.example.testedevices.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/devices") // Mapeia as requisições para /devices
public class DeviceController {

    @Autowired // Injeta a dependência do repositório de dispositivos
    private DeviceRepository deviceRepository;

    @GetMapping // Mapeia requisições GET para /devices
    public List<Device> getAllDevices() {
        return deviceRepository.findAll(); // Retorna todos os dispositivos
    }

    @GetMapping("/{id}") // Mapeia requisições GET para /devices/{id}
    public ResponseEntity<Device> getDeviceById(@PathVariable UUID id) {
        Device device = (Device) deviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found with id " + id)); // Lança exceção se o dispositivo não for encontrado
        return ResponseEntity.ok(device); // Retorna o dispositivo encontrado
    }

    @PostMapping // Mapeia requisições POST para /devices
    public ResponseEntity<Device> createDevice(@RequestBody Device device) {
        Device savedDevice = deviceRepository.save(device); // Salva o novo dispositivo
        return ResponseEntity.ok(savedDevice); // Retorna o dispositivo salvo
    }

    @PutMapping("/{id}") // Mapeia requisições PUT para /devices/{id}
    public ResponseEntity<Device> updateDevice(@PathVariable UUID id, @RequestBody Device deviceDetails) {
        Device device = (Device) deviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found with id " + id)); // Lança exceção se o dispositivo não for encontrado

        device.setName(deviceDetails.getName()); // Atualiza o nome do dispositivo
        device.setStatus(deviceDetails.getStatus()); // Atualiza o status do dispositivo
        device.setLastPing(deviceDetails.getLastPing()); // Atualiza o último ping do dispositivo
        device.setLocation(deviceDetails.getLocation()); // Atualiza a localização do dispositivo

        Device updatedDevice = deviceRepository.save(device); // Salva o dispositivo atualizado
        return ResponseEntity.ok(updatedDevice); // Retorna o dispositivo atualizado
    }

    @DeleteMapping("/{id}") // Mapeia requisições DELETE para /devices/{id}
    public ResponseEntity<Void> deleteDevice(@PathVariable UUID id) {
        Device device = (Device) deviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found with id " + id)); // Lança exceção se o dispositivo não for encontrado

        deviceRepository.delete(device); // Deleta o dispositivo
        return ResponseEntity.noContent().build(); // Retorna uma resposta sem conteúdo
    }
}
