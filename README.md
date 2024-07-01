# Back-End

Esta API de Cadastro permite a criação, atualização, leitura e exclusão de registros de usuários em um sistema. A API foi projetada para ser fácil de usar e segura, suportando operações CRUD (Create, Read, Update, Delete) para gerenciar os dados dos usuários.

Endpoints
1. Criação de Usuário
URL: /api/users
Método HTTP: POST
Descrição: Cria um novo usuário.
Parâmetros de Requisição:
nome (string, obrigatório): Nome do usuário.
email (string, obrigatório): Email do usuário.
senha (string, obrigatório): Senha do usuário.

2. Leitura de Usuário
URL: /api/users/{id}
Método HTTP: GET
Descrição: Retorna os detalhes de um usuário específico.
Parâmetros de Caminho:
id (integer, obrigatório): ID do usuário.
Resposta de Sucesso:
Código: 200 OK

3. Atualização de Usuário
URL: /api/users/{id}
Método HTTP: PUT
Descrição: Atualiza as informações de um usuário específico.
Parâmetros de Caminho:
id (integer, obrigatório): ID do usuário.
Parâmetros de Requisição:
nome (string, opcional): Nome do usuário.
email (string, opcional): Email do usuário.
senha (string, opcional): Senha do usuário.

4. Exclusão de Usuário
URL: /api/users/{id}
Método HTTP: DELETE
Descrição: Exclui um usuário específico.
Parâmetros de Caminho:
id (integer, obrigatório): ID do usuário.
Resposta de Sucesso:
Código: 204 No Content
