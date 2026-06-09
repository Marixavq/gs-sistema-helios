# Helios - Sistema de Gerenciamento de Habitat Espacial

## 🪐 Visão Geral

O projeto consiste em um sistema de gerenciamento de habitats espaciais voltados para futuras operações de colonização e turismo na Lua ou em Marte.

A solução simula o controle de um ambiente espacial habitável, permitindo o monitoramento de condições críticas, gestão de ocupantes, reservas de módulos e integração com sensores ambientais.

O sistema busca garantir segurança, eficiência operacional e confiabilidade em ambientes extremos.

---

## 🛠 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Spring HATEOAS
- Maven
- H2 Database (desenvolvimento)
- Hibernate
- Bean Validation
- Swagger/OpenAPI
- Git & GitHub

---

## 📂 Estrutura do Projeto

O projeto foi estruturado utilizando arquitetura em camadas:

```text
Controller → Service → Repository → Banco de Dados
```

Estrutura em pastas:

    src/main/java
        com.fiap.sistemahelios
            controller
            dto
                dashboard
                request
                response
            exception
            model
            repository
            service
            SistemaheliosApplication.java

---

## 🪐 Entidades Principais
### 🏠 ModuloHabitacional

Representa módulos habitacionais do habitat espacial.

### 👤 Ocupante

Representa os usuários/ocupantes do sistema.

### 📅 Reserva

Representa a estadia de um ocupante em um módulo.

### 📡 Sensor

Representa sensores ambientais dos módulos.

---

## 🔗 Relacionamentos

```text
Habitat
 └── ModuloHabitacional
       ├── Sensor
       │     └── LeituraSensor
       │             └── Alerta
       │                     └── AcaoAutomatica
       │
       └── Reserva
             └── Ocupante

RegraAlerta  → valida LeituraSensor / gera Alerta
LogEvento    ← recebe eventos de todo o sistema
```

---
## ▶ Como Executar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/Marixavq/gs-sistema-helios
```

### 2. Abrir no IntelliJ IDEA

Importar como projeto Maven.

### 3. Executar a aplicação

Rodar a classe principal:

```java
@SpringBootApplication
```

### 4. Acessar API

```text
http://localhost:8080
```

---

## 👨‍💻 Equipe

| Integrante                | RM | Perfil GitHub                                     |
|---------------------------| --- |---------------------------------------------------|
| Arthur dos Santos Cabral  | RM566515 | [ArthurCPV](https://github.com/ArthurCPV)         |
| Bruno Martins Bettio      | RM564939 | [TaikaWaititi](https://github.com/TaikaWaititi)   |
| José Diogo Da Silva Neves | RM562341 | [ZeDio](https://github.com/ZeDio)                 |
| Júlia Tiziotto Buttler    | RM564975 | [JuliaTButtler](https://github.com/JuliaTButtler) |
| Mariana Xavier Quispe     | RM566357 | [Marixavq](https://github.com/Marixavq)           |

---

## 📄 Links do Projeto

Link do projeto no GitHub: https://github.com/Marixavq/gs-sistema-helios

Link do Swagger: http://localhost:8080/swagger-ui/index.html

Deploy no Render:

Vídeo pitch: 

Vídeo arquitetura do projeto: