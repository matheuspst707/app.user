# app.user

Projeto Spring Boot com java versão 8, API desenvolvida para gerenciar registros de clientes, incluindo autenticação de usuários, o sistema suporta dois tipos de usuários: administrador e usuário padrão. O sistema foi construído utilizando Spring Boot e outras tecnologias.   
 
 ## Sobre
O presente projeto tem por finalidade desenvolver uma aplicação que possibilite a autenticação de usuário, basicamente há dois tipos de usuário: 
* usuario_padrao: que possui uma role (permissão) que restringe as funções que o mesmo pode realizar dentro do sistema.
* usuario_admin: que possui acesso total ao sistema, bem como acesso a todas as funcionalidades (CRUD) que o sistema proporciona.
O sistema foi desenvolvido para atender demandas específicas exigidas pelo cliente:

Autenticação: Dois níveis de acesso:  
  - **Usuário admin**: Senha `123qwel@#` - Acesso total.  
  - **Usuário padrão**: Senha `123qwe123` - Acesso restrito.  

- Registro de Clientes**: Permite a inclusão, edição, e visualização de registros.  
  - **Campos obrigatórios**:  
    - Nome (mínimo de 3 caracteres)  
    - CPF (com máscara)  
    - Endereço (CEP, logradouro, bairro, cidade e UF)  
    - Telefone (pelo menos um)  
    - E-mail (pelo menos um)

O Spring Initializr, a ferramenta online para gerar projetos Spring Boot, não oferece mais a opção para selecionar o Java 8 ao criar novos projetos. A partir do Spring Boot 3.x, a versão mínima do Java requerida é a 17. 

Para atender aos requisitos do cliente, geramos o projeto selecionando o Java 17, posteriormente atualizamos no pom.xml todas as dependências e plugins para que fosse
compatível com o java na versão 8.

**CRIAÇÃO DO CRUD**
Como um cliente pode ter mais de um email,telefone e endereço, o relacionamento dessas entidades são de um para muitos, ou seja um usuário pode ter muitos emails, muitos endereços e muiitos telefones. Por isso criamos para cada um desses campos uma entidade (tabela). Realizamos a criação em camadas, Entidades, repositorys, controllers e services. 

Utilizamos um banco de dados no MySQL Workbench(Sistema Gerenciador de Banco de Dados), configuramos o aplication.properties inserindo o link, a senha e o usuário (conforme o seu SGBD).

O CRUD para o registro de clientes está pronto.

**IMPLEMENTAÇÃO DO SPRING SECUTITY**
Devido estarmos na versão 08 e o Spring initializr gerar muitas dependências que não são compatíveis com a versão de java que estammos trabalhando, importamos a dependência manualmente, acessando o explorer do Spring.io, após isso, criamos de forma organizada novos pacotes e classes, como um pacote para o DTO, onde colocamos as nossas classes de altenticação, de usuario e criamos outras classes para nos auxiliar na lógica. Neste caso inserimos o usuario_admin via workbench, mas você também pode conceder a um usuário cadastrado a role (permissão) de admin.

Após a finalização da implementação utilizamos o Postman para verificar se a nosso nível de Authorization, os métodos Post, Put e Delete apenas estarão habilitados para o usuario_admin.

## Tecnologias Utilizadas

- **Java:** 8  
- **Spring / Spring Boot**  
- **Hibernate**  
- **Maven** 
- **MySQL / Workbench**


  

 