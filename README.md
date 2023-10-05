# Gerenciador de Usuários e Alimentos - API REST
Este é um projeto de API REST desenvolvido com o objetivo principal de aprender e consolidar os conceitos de arquitetura de camadas e API REST utilizando tecnologias como Spring Boot, Hibernate, Lombok e PostgreSQL. O projeto consiste em um sistema de gerenciamento de usuários e alimentos.

## Funcionalidades
<img src="/src/main/resources/pics/casoDeUso.png" alt="Diagrama de Caso de Uso">

Atualmente sistema possui duas entidades principais:

### Usuários

- **Listar todos os usuários**: `GET /usuario`
- **Obter detalhes de um usuário específico**: `GET /usuario/{id}`
- **Criar um novo usuário**: `POST /usuario`
- **Atualizar informações de um usuário**: `PUT /usuario/{id}`
- **Excluir um usuário**: `DELETE /usuario/{id}`

### Alimento

- **Listar todos os alimentos**: `GET /comida`
- **Obter detalhes de um alimento específico**: `GET /comida/{id}`
- **Criar um novo alimento**: `POST /comida`
- **Atualizar informações de um alimento**: `PUT /comida/{id}`
- **Excluir um alimento**: `DELETE /comida/{id}`

## Tecnologias Utilizadas
Este projeto foi construído utilizando as seguintes tecnologias e ferramentas:

- **Spring Boot**
- **Hibernate**
- **Lombok**
- **PostgreSQL**

## Agradecimentos
Gostara de expressar minha gratidão à criadora de conteúdo [Fernanda Kipper](https://www.youtube.com/watch?v=lUVureR5GqI) e [Michelli Brito](https://www.youtube.com/watch?v=LXRU-Z36GEU) pela incrível contribuição para a comunidade de desenvolvedores. Seus vídeos foram uma fonte valiosa de aprendizado e inspiração para este projeto.

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para criar Pull Requests com melhorias, correções de bugs ou adição de novos recursos.
