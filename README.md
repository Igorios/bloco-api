# Bloco de Notas

Este projeto tem como objetivo criar um sistema de bloco de notas.

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- PostgreSQL

## Autenticação e autorização

O sistema utiliza o Spring Security para autenticação e autorização. As requisições devem ser autenticadas com um token JWT válido. O token JWT é gerado no endpoint `/api/login` e deve ser incluído nas requisições como um header `Authorization` com o valor `Bearer {token}`.
