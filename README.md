# 🛒 API de Estoque Integrada com Shopee

API desenvolvida em Java com Spring Boot para gerenciar o estoque de uma loja física de controles de TV e ar-condicionado, com integração à API da Shopee para manter os estoques sincronizados.

## 🚀 Tecnologias
- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- REST API
- Shopee OpenAPI (OAuth + Product API)

## 📁 Estrutura do Projeto
src/
├── controller/
├── service/
├── repository/
├── model/
├── dto/
└── shopee/

## ⚙️ Funcionalidades
- Cadastro, edição e listagem de produtos
- Atualização e sincronização de estoque com Shopee
- Autenticação com API da Shopee (OAuth 2.0)
- Agendamento de sincronização automática
- Armazenamento local dos tokens da Shopee

## 🧠 Casos de Uso
- Sincronizar estoque local com Shopee
- Consultar estoque da loja
- Atualizar token automaticamente
- Gerenciar produtos da loja física





