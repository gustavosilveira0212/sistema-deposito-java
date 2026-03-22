# Sistema de Cadastro de Produtos

Projeto desenvolvido para gerenciar cadastro de produtos, permitindo adicionar, listar, atualizar e remover dados do banco, bem como fazer o registro de novos usuários, novos STAFF's gerenciado por ID's 
(cada ID tem uma permissão específica dentro do sistema)

## Funcionalidades

- Cadastro de produtos
- Listagem de produtos
- Atualização de dados
- Remoção de produtos
- Integração com banco de dados MySQL
 
## Tecnologias

- Java
- MySQL
- JDBC
- Git e GitHub

🗄️ Estrutura do banco

## Banco de dados

Tabela: PRODUTO

- idProduto (INT, PK)
- nomeProduto (VARCHAR)
- valorProduto (DOUBLE)
- quantidadeProduto (INT)

Tabela: CARRINHO
- idcarrinho (INT, PK)
- idUsuario (INT)
- idProduto (INT)
- quantidadeCarrinho (INT)

Tabela: STAFF
- idstaff (INT, PK)
- cpfStaff (VARCHAR)
- emailStaff (VARCHAR)
- nomeStaff (VARCHAR)
- senhaStaff (VARCHAR)
- codigoStaff (INT)

Tabela: Usuário
- idcliente (INT, PK)
- cpfcliente (VARCHAR)
- emailcliente (VARCHAR)
- nomecliente (VARCHAR)
- senhacliente (VARCHAR)
- codigocliente (INT)

## Aprendizados

- Uso de JDBC para conexão com banco
- Estrutura DAO em Java
- Boas práticas com PreparedStatement

## Autores

- Gustavo Silveira Prado, Jeferson e Marcos.
- Projeto desenvolvido para disciplina e aprendizado.

## Status do projeto

🚧 Em desenvolvimento
