# Trabalho 2 de Construcao de Software

## Resumo
  Aplicacao desenvolvida em cima da solução https://github.com/guilhermeparis/ConstrucaoSW para atender os requisitos do trabalho 2 da disciplina de Construção de Software da PUCRS.
  
  Solução conta com uma interface desenvolvida em cima das rotas disponibilizadas pelo trabalho acima, ou seja, é feita a conexão do JAVA por meio de um 
  menu (console) onde é possivel registrar, alterar, excluir e listar carros, concessionarias, clientes e alocações.
  
## Como utilizar a aplicação:
  É disponibilizado as operações: "Create", "Read", "Update", "Delete", "List" e "Quit".
  
   * Opção 1 - Create: Função para inserir um novo registro em alguma tabela no banco de dados.
  Ao selecionar a opção 1 sera necessário passar o nome da tabela em que se deseja inserir o novo registro, e após isso passar os atributos do dado
  no formato: **nomedacoluna:valor,nomedacoluna2:valor...nomedacolunaN:valor**. 
  (Sem espaços, separado por virgula e dois pontos entre atributo e valor, Para representar espaços use _ (underline)).
  
  Exemplo de inserção de um novo cliente:
  
  ```
  Digite o nome da tabela:
  cliente
  Digite os atributos e os valores a serem criados no formato 'atributo: valor, atributo: valor, ...'
  cpf:123456789,nome:Bruno  
  ```
    
  É importante que o formato seja exatamente o descrito acima, do contrario a operação não sera realizada com sucesso.
  
  * Opção 2 - Read - Função para retornar na tela um registro já existente no banco de dados.
  Ao selecionar a opção 2 sera necessário passar o nome da tabela em que se deseja consultar um registro, **e após isso passar o ID (identificador unico)
  que essa tabela em questão tem. Por exemplo verificar a tabela "cliente", lá o ID é representado pelo CPF**.
  
  Exemplo de leitura de um cliente já existente:
  
  ```
  Digite o nome da tabela:
  cliente
  Digite o id
  123456789
  ```
  Assim sera mostrado na proxima linha do console o registro buscado.
  
  * Opção 3 - Update - Função para atualizar algum registro já existe no banco de dados.
  Ao selecionar a opção 3 sera necessário passar o nome da tabela em que se dejesa atualizar um registro,
  Após isso o ID (identificador unico) da tabela em questão, por exemplo a tabela "cliente" tem a coluna "CPF" como ID, por favor verificar a aplicação já existente para verificar como foi feito.
  Após isso a atualização se da pela mesma forma que é feita no "Create", no formato: **nomedacoluna:valor,nomedacoluna2:valor...nomedacolunaN:valor**. 
  
  Exemplo pratico de atualização da coluna nome (Atualização do registro inserido nos steps acima).
  
  ```
  Digite o nome da tabela:
  cliente
  Digite o id
  123456789
  nome:Bruno 
  ```
  
  * Opção 4 - Delete -Função para deletar um registro do banco de dados.
  Ao selecionar a opção 4 sera necessário informar o nome da tabela em que se deseja excluir um registro.
  Após isso o ID (identificador unico) da tabela em questão, por exemplo a tabela "cliente" tem a coluna "CPF" como ID, por favor verificar a aplicação já existente para verificar como foi feito.
  Feito isso o cliente sera deletado com sucesso.
  
  Exemplo pratico da ação de deletar um cliente. (O mesmo inserido acima).
  
  ```
  Digite o nome da tabela:
  cliente
  Digite o id
  123456789
  ```
  
  * Opção 5 - List -Função para listar todos os registros de uma tabela do banco de dados.
    Ao selecionar a opção 2 sera necessário passar o nome da tabela em que se deseja consultar os registros.
     
    Exemplo pratico da ação de consultar todos os clientes.
       
   ```
    Digite o nome da tabela:
    cliente

   ```
  
  * Opção 6 - Quit - Opção para encerrar a execução da aplicação.
    
  Observação: Este é uma documentação de uso para o usuário final, definições técnicas podem ser consultadas diretamente no manual técnico disponibilizado no dia 21/11 para aplicação com finalidade para reúso em que essa solução foi desenvolvida em cima, no link abaixo:
  https://github.com/guilhermeparis/ConstrucaoSW
  

  
  
