# 🌱 AgroSphere API

## Sobre o Projeto

O AgroSphere é uma API REST desenvolvida em Java com Spring Boot para monitoramento agrícola inteligente.

A solução utiliza sensores instalados em fazendas para coletar informações ambientais, permitindo o acompanhamento de temperatura, umidade e outras métricas importantes para a produção agrícola.

O projeto está alinhado ao tema da Global Solution 2026 da FIAP, utilizando tecnologia e análise de dados para apoiar o agronegócio por meio de monitoramento inteligente e tomada de decisão baseada em informações coletadas em campo.

---

##  Objetivo

Auxiliar produtores rurais no monitoramento de suas propriedades através da coleta e gerenciamento de dados provenientes de sensores agrícolas.

---

##  Arquitetura

A aplicação segue o padrão de arquitetura em camadas:

* Controller
* Service
* Repository
* Entity
* DTO

Além disso, utiliza:

* Spring Security
* JWT Authentication
* Spring Data JPA
* Swagger/OpenAPI
* Validation
* Exception Handling

---

##  Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Security
* JWT
* Spring Data JPA
* Hibernate
* H2 Database
* Lombok
* Swagger/OpenAPI
* Maven

---

##  Entidades Principais

### Usuário

Responsável pela autenticação e acesso ao sistema.

### Fazenda

Representa uma propriedade agrícola cadastrada.

### Sensor

Dispositivo responsável pela coleta de dados.

### Medição

Registra informações coletadas pelos sensores.

### Alerta

Notificações geradas a partir das medições realizadas.

---

##  Segurança

A API utiliza autenticação baseada em JWT (JSON Web Token).

Fluxo:

1. Realizar login.
2. Receber Token JWT.
3. Utilizar o token no header Authorization:

Bearer seu_token

---

## Swagger

Após iniciar a aplicação:

http://localhost:8080/swagger-ui/index.html


---


## Integrantes

* Vitor Mendes da Silva – RM 565376
* Aguinel Junior – RM 564857
* Henrique Gonçalves – RM 562086
* Leonardo Saavedra - RM 562229
* Felipe da Silva - RM 564857

---

## 🎥 Vídeo de Apresentação

Link Projeto: https://youtu.be/4CU3tFmwbFU

Link Pitch: https://youtu.be/fkL699Wi4qA

---




