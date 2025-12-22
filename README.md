# 📚 Sistema de Gestão Acadêmica (SGA) – Backend API

## 📌 Visão Geral do Projeto

O **Sistema de Gestão Acadêmica (SGA)** é uma API REST desenvolvida em **Java com Spring Boot**, cujo objetivo é gerenciar **Cursos** e **Alunos** de uma instituição de ensino.

Este projeto foi desenvolvido como parte da **Atividade Prática Supervisionada (APS)** da disciplina de **Programação Orientada a Objetos (POO)**, com foco em boas práticas de desenvolvimento backend corporativo, utilizando arquitetura em camadas, persistência com JPA e banco de dados relacional em memória.

A API serve como base para futuras aplicações frontend (web ou mobile).

---

## 🚀 Tecnologias Utilizadas

- **Java:** JDK 17+
- **Spring Boot:** 3.x
- **Spring Web**
- **Spring Data JPA**
- **Banco de Dados:** H2 (em memória)
- **Gerenciador de Dependências:** Maven
- **Testes:** Postman / Insomnia

---

## 🗂 Estrutura do Projeto

```
sga/
├── src/main/java/com/gestao/sga
│   ├── controller
│   ├── model
│   ├── repository
│   ├── service
│   └── SgaApplication.java
├── src/main/resources
│   └── application.properties
└── pom.xml
```

---

## 🧱 Arquitetura da Aplicação

Arquitetura em camadas:
- Controller
- Service
- Repository
- Model

---

## 🗄️ Configuração do Banco de Dados (H2)

```properties
spring.datasource.url=jdbc:h2:mem:sga_db
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
```

Console: `http://localhost:8080/h2-console`

---

## 🔗 Endpoints da API

### Cursos `/api/cursos`
- POST – cadastrar
- GET – listar
- GET /{id}
- DELETE /{id}

### Alunos `/api/alunos`
- POST – cadastrar
- GET – listar
- GET /{id}
- PUT /{id}
- DELETE /{id}

---

## ▶️ Como Executar o Projeto

1. Importar como projeto Maven
2. Executar `SgaApplication`
3. Acessar `http://localhost:8080`

---

## 📝 Observações Finais

Projeto desenvolvido para fins educacionais seguindo boas práticas de API REST.
