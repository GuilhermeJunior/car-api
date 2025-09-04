# Projeto de Cadastro de Carros

Este é um projeto simples de API RESTful para cadastro de carros, desenvolvido com **Spring Boot 3.2.0** e **Maven**. O objetivo principal é servir como um backend para a integração e teste de um frontend desenvolvido em Angular, validando um CRUD (Create, Read, Update, Delete) básico.

---

## Requisitos

Para executar esta aplicação, você precisará ter instalado em sua máquina:

* **Java Development Kit (JDK)**: Versão 17 ou superior.
* **Maven**: O projeto utiliza o Maven Wrapper, então uma instalação local do Maven não é estritamente necessária.

---

## Como Executar o Projeto

Você pode executar a aplicação diretamente pela linha de comando usando o **Maven Wrapper (`mvnw`)**. Isso garante que a versão correta do Maven seja usada, independentemente da sua instalação local.

1.  **Navegue até o diretório do projeto**: Abra o terminal ou prompt de comando e vá para a pasta raiz do seu projeto.

    ```bash
    cd /caminho/para/seu/projeto
    ```

2.  **Execute o projeto**: Use o comando do Spring Boot Maven Plugin para rodar a aplicação.

    ```bash
    ./mvnw spring-boot:run
    ```

    * No Windows, você pode usar `mvnw.cmd` em vez de `./mvnw`.

3.  **Aguarde a inicialização**: O Spring Boot vai iniciar o servidor web embarcado (por padrão, o Tomcat) na porta **8080**. Você verá uma mensagem no console indicando que a aplicação foi iniciada com sucesso.

    ```
    Tomcat started on port(s): 8080 (http) with context path ''
    ```

---

## Rotas da API

A API expõe as seguintes rotas para a entidade `Carro` na URL base `http://localhost:8080`:

| Método HTTP | Rota                 | Descrição                            |
| :---------- | :------------------- | :----------------------------------- |
| `POST`      | `/api/carros`        | Cria um novo carro.                  |
| `GET`       | `/api/carros`        | Lista todos os carros cadastrados.   |
| `GET`       | `/api/carros/{id}`   | Busca um carro específico pelo seu ID. |
| `PUT`       | `/api/carros/{id}`   | Atualiza os dados de um carro existente. |
| `DELETE`    | `/api/carros/{id}`   | Exclui um carro pelo seu ID.         |

Você pode usar ferramentas como Postman ou Insomnia para testar os endpoints da API.