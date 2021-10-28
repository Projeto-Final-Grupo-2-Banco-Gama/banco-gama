
# Projeto Final - ItauTECH
## Equipe Tech Master:

- <p style="color: orange;">O Desafio Final - ItauTECH - é um projeto em grupo que foi desenvolvido durante o Programa de Formação Tech do Itaú em parceria com a Gama Academy</p>

#
### Topicos:

- [Descrição do projeto](#Desafio)
- [Objetivo ](#Objetivos)
- [Especificações](#Especificações)
- [Entregaveis](#Entregáveis)
- [Consultas Extras](#Consultas)

#
### 💻 Desenvolvedores 

### Entre em contato conosco:

<details>
    <summary>Assis Daniel</summary>

[![Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/assis-daniel-sales-pcd-458570168/)
[![Github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/AssDan)


</details>

<details>
    <summary>Daniela Cury</summary>

[![Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/daniela-cury/)
[![Github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/danicury06)

</details>

<details>
    <summary>Eduardo Rocha</summary>

[![Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/eduardo-rocha-25870a1a6/)
[![Github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/syaoranea)

</details>

<details>
    <summary>Erike Rodrigues</summary>

[![Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/erike-rodrigues-b5b060213)
[![Github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Erike-Rodrigues)

</details>

<details>
    <summary>Fernando Kendi Utida</summary>

[![Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/fedkendi/)
[![Github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/fedkendi)

</details>

<details>
    <summary>Fabricio Messias</summary>

[![Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/fabricio-messias/)
[![Github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/FabricioMessias)

</details>

#
### Desafio:

Estamos em um contexto de gerenciamento de clientes e contas bancárias da instituição.
Precisamos disponibilizar uma API que forneça dados de clientes e contas (inicialmente para
consulta).
#

### Tecnologias utilizadas: 

### Objetivos:
Construir uma API Spring BOOT que possua 2 endpoints principais:

a. Recuperação de todas as contas bancárias

b. Recuperação dos detalhes de 1 conta bancária (inclusive dados do seu titular)
#

### Especificações:

Algumas tecnologias são obrigatórias para este projeto:

Banco de Dados: MySQL

API: SpringBoot

Modelagem de Dados:
Todo cliente possui os seguintes dados para serem cadastrados

● codigo interno

● nome

● cpf

● telefone

● email
#

Toda conta bancária possui os seguintes dados

● numero

● agência

● tipo da conta (0 - conta corrente, 1 - poupança, 2 - investimento)

● saldo

● titular da conta
#

### Entregáveis:

Endpoint para consulta de todas as contas (deve retornar uma lista de objetos do tipo
que armazena Conta Bancária):

    /contas

Endpoint para consultas do detalhe da conta

    /contas/{id}

Todos os dados devem ser retornados em formato JSON.

#
### Consultas:

 Novos Endpoints para consultas adicionadas pela equipe.

- consultar todas as contas de um tipo específico

         /contas/tipo/{tipo}

- consultar todos os clientes ordenados pelo nome

        /cliente/todosordenadopornome

- consultar todas as contas de um cliente pelo seu nome

        /cliente/contasdocliente

- consultar os dados de um cliente específico

        /cliente/nome

- consultar todas as contas e dados dos clientes em Páginas

        /contas/listarempaginas?size=4&page=0

- criar novo cliente

        /cliente/novo

- atualizar dados do cliente

        /cliente/atualizar

- criar nova conta para um cliente

        /contas/novo

- apagar cliente pelo código único do cliente

        /cliente/apagar/{codigo}

- atualizar dados da conta

        /contas/atualizar

- apagar conta pelo código da conta

        /contas/apagar/{codigo}

- consultar os contatos de todos os clientes

        /contatotodosclientes

- consultar os contato de um cliente específico

        /contatocliente/{codigo}

#
### Ferramenta:

Visual Studio Code Windows

Postman

MySQL Workbench 8.0 CE

#
<div style="display: inline_block">
    <img align="center" alt="Java" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" />
    <img align="center" alt="Spring" src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
    <img align="center" alt="Mysql" src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white" />
</div>








