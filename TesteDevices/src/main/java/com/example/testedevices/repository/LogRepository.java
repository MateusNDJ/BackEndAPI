package com.example.testedevices.repository;

import com.example.testedevices.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LogRepository extends JpaRepository<Log, UUID> {
    // Interface para operações CRUD na entidade Log, utilizando UUID como tipo de ID
}
