# ☀️ Helios - Sistema de Gerenciamento de Habitat Espacial

## 🪐 Visão Geral

O projeto consiste no desenvolvimento de um sistema inteligente de gerenciamento de habitats espaciais autônomos, voltado ao suporte de operações em ambientes extremos como Lua ou Marte. A proposta surge da necessidade de monitoramento contínuo e confiável de condições ambientais críticas em cenários de exploração espacial, onde falhas operacionais podem comprometer diretamente a segurança e a sobrevivência dos ocupantes.       

Além de conter simulações de reservas, o sistema é estruturado como uma plataforma de controle e supervisão de infraestrutura habitacional espacial. O foco principal está no gerenciamento de módulos habitacionais, no monitoramento de recursos essenciais e na análise de condições ambientais em tempo real, permitindo uma visão integrada do estado geral do habitat.     

Nosso sistema visa garantir segurança, eficiência operacional e confiabilidade em ambientes extremos.

---

## 🛠 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Spring HATEOAS
- Maven
- H2 Database 
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
Usuario
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

Deploy no Render: https://gs-sistema-helios.onrender.com
