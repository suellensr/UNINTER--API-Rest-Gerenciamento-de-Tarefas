# Documentação da API de Gerenciamento de Tarefas

## Visão Geral

Esta API Restful foi desenvolvida como um trabalho para a disciplina de **Desenvolvimento Web Back-end** do curso de **Análise e Desenvolvimento de Software** da **Uninter**. O objetivo principal é fornecer endpoints para gerenciar tarefas, permitindo operações como criar, listar, visualizar, editar e deletar.

---

## Estrutura do Projeto

A API é construída em **Java** e utiliza o framework **Spring Boot** para a criação dos endpoints. A arquitetura segue o padrão REST, facilitando a integração com diferentes clientes, como aplicações web e mobile.

---

## Endpoints da API

A base da URL para todos os endpoints é `http://localhost:8080/tarefas`. Abaixo estão os detalhes de cada endpoint disponível.

### 1. Listar Todas as Tarefas

Este endpoint recupera uma lista de todas as tarefas salvas no sistema.

* **Método:** `GET`
* **URL:** `/listar`
* **Descrição:** Retorna um array JSON com todos os objetos de tarefa.
* **Exemplo de Resposta (Status 200 OK):**
    ```json
    [
      {
        "id": 1,
        "nome": "Desenvolvimento da API",
        "dataEntrega": "2025-09-12",
        "responsavel": "Maria"
      },
      {
        "id": 2,
        "nome": "Implementação da tela de login",
        "dataEntrega": "2025-09-15",
        "responsavel": "Ana"
      }
    ]
    ```

---

### 2. Salvar uma Nova Tarefa

Este endpoint permite criar uma nova tarefa no banco de dados.

* **Método:** `POST`
* **URL:** `/salvar`
* **Descrição:** Salva uma nova tarefa no sistema.
* **Corpo da Requisição (JSON):**
    ```json
    
    {
      "nome": "Implementação da tela de login",
      "dataEntrega": "2025-09-15",
      "responsavel": "Ana"
    }
    ```
* **Observações:** O campo `dataEntrega` deve ser enviado no formato **`YYYY-MM-DD`**.
* **Exemplo de Resposta (Status 200 OK):** Retorna o objeto da tarefa criada, incluindo o `id` gerado.
    ```json
    {
      "id": 2,
      "nome": "Implementação da tela de login",
      "dataEntrega": "2025-09-15",
      "responsavel": "Ana"
    }
    ```

---

### 3. Visualizar uma Tarefa por ID

Este endpoint retorna os detalhes de uma tarefa específica, utilizando seu ID único.

* **Método:** `GET`
* **URL:** `/tarefas/exibir/{id}`
* **Parâmetro de URL:**
    * `{id}` (integer): O ID da tarefa a ser visualizada.
* **Descrição:** Busca uma única tarefa pelo seu ID.
* **Exemplo de Resposta (Status 200 OK):**
    ```json
    {
      "id": 1,
      "nome": "Desenvolvimento da API",
      "dataEntrega": "2025-09-12",
      "responsavel": "Maria"
    }
    ```
* **Códigos de Erro:**
    * `404 Not Found`: A tarefa com o ID especificado não foi encontrada.

---

### 4. Editar uma Tarefa Existente

Este endpoint atualiza os dados de uma tarefa já existente no sistema.

* **Método:** `PUT`
* **URL:** `/tarefas/editar/{id}`
* **Parâmetro de URL:**
    * `{id}` (integer): O ID da tarefa a ser editada.
* **Corpo da Requisição (JSON):**
    ```json
    {
      "nome": "Refatoração de código da API",
      "dataEntrega": "2025-09-20",
      "responsavel": "Maria"
    }
    ```
* **Descrição:** Atualiza uma tarefa pelo seu ID, utilizando os dados fornecidos no corpo da requisição.
* **Observações:** O campo `dataEntrega` deve ser enviado no formato **`YYYY-MM-DD`**.
* **Exemplo de Resposta (Status 200 OK):** Retorna o objeto da tarefa atualizada.
    ```json
    {
      "id": 1,
      "nome": "Refatoração de código da API",
      "dataEntrega": "2025-09-20",
      "responsavel": "Maria"
    }
    ```

---

### 5. Deletar uma Tarefa

Este endpoint remove uma tarefa do sistema permanentemente.

* **Método:** `DELETE`
* **URL:** `/tarefas/deletar/{id}`
* **Parâmetro de URL:**
    * `{id}` (integer): O ID da tarefa a ser deletada.
* **Descrição:** Remove uma tarefa do banco de dados.
* **Exemplo de Resposta (Status 200 OK):** Geralmente retorna uma resposta vazia ou uma mensagem de sucesso.
* **Códigos de Erro:**
    * `404 Not Found`: A tarefa com o ID especificado não existe.

---

### Como Usar com Postman

Para testar esta API, você pode usar o **Postman** ou qualquer outra ferramenta de sua preferência.

1.  Clone este repositório.
2.  Execute o projeto Spring Boot.
3.  Utilize os endpoints acima, substituindo `http://localhost:8080` pelo endereço do seu servidor.

### Créditos

* **Desenvolvedor:** Suellen S. Reis
* **Disciplina:** Desenvolvimento Web Back-end
* **Instituição:** UNINTER
