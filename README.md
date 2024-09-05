# TesteDevicesApplication

## Descrição

Este projeto é uma aplicação Spring Boot para gerenciar dispositivos e seus logs. Ele fornece uma API REST para criar, atualizar, deletar e buscar dispositivos, além de registrar logs associados a esses dispositivos.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.0
- Spring Data JPA
- H2 Database
- Maven

## Estrutura do Projeto

- **config**: Contém as configurações de segurança e banco de dados.
- **controller**: Contém os controladores REST para gerenciar dispositivos e logs.
- **model**: Contém as entidades JPA `Device` e `Log`.
- **repository**: Contém os repositórios JPA para `Device` e `Log`.
- **service**: Contém a lógica de negócios para gerenciar dispositivos.

## Pré-requisitos

- JDK 17 ou superior
- Maven 3.6 ou superior

## Configuração do Banco de Dados

O projeto está configurado para usar um banco de dados H2 em memória. As configurações estão no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
