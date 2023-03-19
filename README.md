# Projeto: Microsserviços faculdade
Repositório contendo o projeto em desenvolvimento sobre comunicação entre microsservicos, [com base ao projeto do app clone da estacio:  ](https://github.com/andre06x/native-estacio)

## Tecnologias

* **Java**
* **Spring Boot**
* **Javascript ES6**
* **Node.js**
* **Sequelize**
* **ES6 Modules**
* **Express.js**
* **MongoDB (Container e Cloud MongoDB)**
* **API REST**
* **PostgreSQL (Container)**
* **Docker**
* **docker-compose**
* **JWT**
* **Spring Cloud OpenFeign**
* **Axios**
* **spring-cloud-gateway**
* **Spring Cloud Netflix**


## Arquitetura Proposta
Ao final do projeto teremos 5 APIs:

<div  align="center">
  <img src="https://user-images.githubusercontent.com/67429807/226188411-7dea0261-2255-4bd1-b2c1-d5ad2bc33275.png" />
    <img src="https://user-images.githubusercontent.com/67429807/226188929-282d8fef-fa05-4e3b-a977-934939001e09.png" />
</div>


* **Matricula-API**: API contendo as matriculas e realizando a autenticação com Node.js, Express.js, Sequelize, PostgreSQL, Axios, JWT e Bcrypt.
* **Usuario-API | Disciplina-API | Boleto-API**: Ambas API com Java , Spring Boot, Spring Data JPA, PostgreSQL, validação de JWT e Spring Cloud OpenFeign para clients HTTP.
* **Log-API**: API de logs do app com Node.js, Express.js, MongoDB, Mongoose, validação de JWT e Axios para clients HTTP.

Também teremos toda a arquitetura rodando em containers docker via docker-compose.


