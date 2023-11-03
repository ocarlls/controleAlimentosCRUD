# Controle Alimentar e Dietético
Este é um projeto em construção de um API REST desenvolvido com o objetivo principal de aprender e consolidar os conceitos 
de arquitetura de camadas e API REST utilizando tecnologias como Spring Boot, Hibernate, Lombok e PostgreSQL.
Inspirado pelo popular aplicativo MyFitnessPal. O projeto consiste em um sistema de gerenciamento de dieta com o principal foco no controle de ingestão calórica
e macronutrientes diários. Buscando oferece uma maneira conveniente de registrar informações sobre o que você come e bebe. 

## Funcionalidades
### Diagrama de caso de uso
<img src="/src/main/resources/pics/casoDeUso.png" alt="Diagrama de Caso de Uso">

### Diagrama de classes
<img src="/src/main/resources/pics/classes.png" alt="Diagrama de Classes">

Atualmente, o projeto inclui as seguintes funcionalidades:

### Usuários
- **Criar um novo usuário**: `POST /auth/register`
- **Logar com uma conta** `POST /auth/login`

### Alimento

- **Listar todos os alimentos**: `GET /comida`
- **Obter detalhes de um alimento específico**: `GET /comida/{id}`
- **Criar um novo alimento**: `POST /comida`
- **Atualizar informações de um alimento**: `PUT /comida/{id}`
- **Excluir um alimento**: `DELETE /comida/{id}`

## Funcionalidades Futuras
Tenho o foco de expandir este projeto para incluir todas as funcionalidades abrangentes de controle de dieta e condicionamento físico, semelhantes ao MyFitnessPal. 
Algumas das funcionalidades planejadas incluem:

- **Registro de Refeições:** Os usuários poderão registrar suas refeições, especificando os alimentos e as quantidades consumidas.

- **Contagem de Calorias e Nutrientes:** O aplicativo calculará automaticamente a ingestão de calorias e nutrientes com base nas informações inseridas.

- **Planejamento de Refeições:** Os usuários poderão criar planos de refeições personalizados para atender às suas metas nutricionais.

- **Relatórios e Gráficos:** Visualização de dados e estatísticas para acompanhar o progresso ao longo do tempo.

- **Auxilio e Supervisão:** na escolha de estratégia alimentar adequada aos objetivos do usuário obtida por meio da Regressão Linear utilizando machine learnig.

## Tecnologias Utilizadas
Este projeto foi construído utilizando as seguintes tecnologias e ferramentas:

- **Spring Boot**
- **Hibernate**
- **Lombok**
- **PostgreSQL**
- **JWT authentication**
- **Swagger**

## Agradecimentos
Gostara de expressar minha gratidão à criadora de conteúdo [Fernanda Kipper](https://www.youtube.com/watch?v=lUVureR5GqI) e [Michelli Brito](https://www.youtube.com/watch?v=LXRU-Z36GEU) pela incrível contribuição para a comunidade de desenvolvedores. Seus vídeos foram uma fonte valiosa de aprendizado e inspiração para este projeto.

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para criar Pull Requests com melhorias, correções de bugs ou adição de novos recursos.
