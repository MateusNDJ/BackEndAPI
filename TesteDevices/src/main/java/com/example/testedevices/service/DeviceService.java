package com.example.testedevices.service;

import com.example.testedevices.controller.ResourceNotFoundException;
import com.example.testedevices.model.Device;
import com.example.testedevices.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service // Indica que esta classe é um serviço do Spring
public class DeviceService {

    @Autowired // Injeta a dependência do repositório de dispositivos
    private DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll(); // Retorna todos os dispositivos
    }

    public Device getDeviceById(UUID id) {
        return (Device) deviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found with id " + id)); // Lança exceção se o dispositivo não for encontrado
    }

    public Device createDevice(Device device) {
        return deviceRepository.save(device); // Salva o novo dispositivo
    }

    public Device updateDevice(UUID id, Device deviceDetails) {
        Device device = (Device) deviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found with id " + id)); // Lança exceção se o dispositivo não for encontrado
        device.setName(deviceDetails.getName()); // Atualiza o nome do dispositivo
        device.setStatus(deviceDetails.getStatus()); // Atualiza o status do dispositivo
        device.setLastPing(deviceDetails.getLastPing()); // Atualiza o último ping do dispositivo
        device.setLocation(deviceDetails.getLocation()); // Atualiza a localização do dispositivo
        return deviceRepository.save(device); // Salva o dispositivo atualizado
    }

    public void deleteDevice(UUID id) {
        Device device = (Device) deviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found with id " + id)); // Lança exceção se o dispositivo não for encontrado
        deviceRepository.delete(device); // Deleta o dispositivo
    }
}
