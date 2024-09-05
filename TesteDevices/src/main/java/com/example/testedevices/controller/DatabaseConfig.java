package com.example.testedevices.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration // Indica que esta classe contém definições de beans
public class DatabaseConfig {

    @Bean
    public CommandLineRunner validateDatabaseConnection(DataSource dataSource) {
        return args -> {
            try (Connection connection = dataSource.getConnection()) {
                System.out.println("Conexão com o banco de dados estabelecida com sucesso!"); // Mensagem de sucesso na conexão
            } catch (SQLException e) {
                System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage()); // Mensagem de erro na conexão
                // Adicione lógica para lidar com a falha de conexão, se necessário
            }
        };
    }
}
