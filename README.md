

# Microserviço de Usuários e Envio de E-mails  

Este projeto é um **microserviço** para gerenciamento de usuários e envio de e-mails assíncronos utilizando **Spring Boot**, **RabbitMQ**, **PostgreSQL** e **PgAdmin**.  

## Tecnologias Utilizadas  
- **Spring Boot**  
- **RabbitMQ**  
- **PostgreSQL**  
- **PgAdmin**  
- **Docker**  

## Configuração  

Para rodar o projeto, siga os passos abaixo:  

1. **Subir os containers com Docker Compose**:  
   ```sh
   docker-compose up -d
   ```
2. **Configurar o envio de e-mails** no `application.properties`. O serviço de e-mail não está configurado por padrão.  

3. **Testar a API** utilizando **Postman** ou **cURL**.  

## Testando a API  

### Criar um usuário  
Endpoint:  
```
POST //users
```
Corpo da requisição (JSON):  
```json
{
  "name": "João Silva",
  "email": "joao@email.com"
}
```
Isso enviará os dados para a fila do RabbitMQ.  

## Monitoramento  

Para **monitorar as filas** no RabbitMQ, acesse no navegador:  
```
http://localhost:15672
```
Login: **guest**  
Senha: **guest**  

Caso o RabbitMQ não esteja instalado, basta rodar o **Docker Compose** novamente.  

## Acesso ao PgAdmin  

Acesse:  
```
http://localhost:5050
```
- **Usuário:** `admin@admin.com`  
- **Senha:** `admin`  

Se precisar editar o banco, pode fazer isso diretamente no PgAdmin.  

