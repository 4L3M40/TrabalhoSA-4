# Sistema Escolar - Gestão de Pessoas | Trabalho SENAI SA.4

## Descrição do Projeto
Este projeto é um **sistema escolar simples** desenvolvido em **Java**, com foco na gestão de **Pessoas**, **Estudantes** e **Professores**. Utilizando **JDBC** para comunicação com o banco de dados MySQL, ele permite realizar operações básicas de CRUD (Criar, Ler, Atualizar e Deletar) para essas entidades.

O sistema foi estruturado com o objetivo de gerenciar informações como nome, email, matrícula e departamento dos envolvidos no processo escolar. Ele pode ser expandido para incluir novos módulos ou funcionalidades de acordo com as necessidades do projeto.

---

## Arquitetura
A arquitetura do sistema é simples e segue a estrutura tradicional de camadas:
- **Modelo**: Contém as entidades representando as tabelas do banco de dados (ex.: `Pessoa.java`, `Estudante.java`, `Professor.java`).
- **DAO (Data Access Object)**: Responsável pela persistência dos dados no banco, com implementação de operações CRUD (ex.: `PessoaDAO.java`, `EstudanteDAO.java`, `ProfessorDAO.java`).
- **Main**: Classe principal que inicializa e manipula as operações do sistema, realizando inserção de dados no banco e buscando as informações conforme necessário.

---

## Funcionalidades Implementadas
- **CRUD de Pessoas**:
  - Criar, ler, atualizar e deletar informações de pessoas.
- **Associação de Estudantes e Professores**:
  - Associar pessoas a estudantes e professores, com base nos seus dados.
- **Persistência de Dados no Banco MySQL**:
  - Integração com o banco MySQL para armazenar informações.

---

## Dependências Utilizadas
As principais dependências do projeto são:
- **JDBC (Java Database Connectivity)**: Para comunicação com o banco de dados MySQL.
- **MySQL Driver**: Para conexão com o banco MySQL.

---

## Endpoints Principais
O projeto não possui endpoints REST, mas realiza operações CRUD diretamente no banco de dados por meio da lógica implementada no `Main.java`.

- **Inserção de Pessoas**: Criação de registros no banco para pessoas.
- **Associação de Estudantes e Professores**: Relacionamento entre as pessoas com base em seu tipo (estudante ou professor).

---

## Como Executar o Projeto
1. Configure o banco de dados MySQL:
   - Crie um banco de dados `escola` no MySQL.
   - Configure as tabelas correspondentes às entidades `Pessoa`, `Estudante` e `Professor`.

2. No código fonte, utilize a classe `Main.java` para realizar a inserção dos dados no banco.

   - Certifique-se de que o banco de dados MySQL esteja rodando.
   - Execute o projeto e observe a inserção dos dados no banco de dados.
   
---

## Observações
Este sistema foi desenvolvido de forma simples, com foco na integração entre Java e MySQL. Embora não tenha sido utilizado um framework como o Spring, o projeto pode ser facilmente expandido e adaptado para incluir novos recursos, como APIs RESTful, se necessário.

A separação de responsabilidades entre as entidades e os DAOs facilita a manutenção e a escalabilidade do sistema.
