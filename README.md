# JAVA-JDBC
Projeto Java com JDBC - CRUD


Acesso a banco de dados com JDBC.


 Principais recursos do JDBC na teoria e prática.

 Estrutura básica de um projeto com JDBC.


JDBC (Java Database Connectivity): API padrão do Java para acesso a dados.


Aplicação com Java> JDBC Driver Manager> JDBC Driver para Bancos de dados(PostgreSQL, Oracle, Workbench...) > Database de bancos de dados(PostgreSQL, Oracle, Workbench...).

<br>
APLICAÇÃO


Configurado o ambiente com o MySQL Java Connector;


Criado a database no Workbench;


Criado o arquivo db.properties com os dados do banco de dados;


Criado exceção personalizada;


Criado metodos auxiliares para obter e fechar uma conexão com o banco;


 -Método para criar fluxo de entrada e ler o arquivo;
 
 -Método para executar SQL, gerenciar o driver JDBC e fazer conexão com o banco;

<br>

CRUD


R: Ler os dados do banco de dados:
Metodo para consultar e exibir os dados com Statement para montar o comando SQL que será executado e ResultSet para apresentar esse resultado da query SQL em forma de tabela.

C: Inserindo dados no banco de dados:
Utilizado o Prepare Statement, pois apresenta maior segurança diante o Statement. Inserção com recuperação de Id com Statement.RETURN_GENERATED_KEYS e getGeneratedKeys.

U: Atualizando dados no banco de dados:

D: Deletando dados no banco de dados:
Conceito de integridade referencial, cascata.

Transação 

Manter a consistência do banco de dados:

Atômica: acontece por inteiro ou nada;

Consistênte: Começa e termina;

Isolada: Precisa estar e acontecer isolada de outras transações;

Durável: Não pode ser reversível.

