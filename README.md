# ⚡ InvestThor - Agregador de Cotações

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.1-green)

### 📋 Sobre o Projeto
Microsserviço de backend prático que consulta uma API financeira externa, filtra as ações de uma carteira que estão em alta e retorna os resultados ordenados pelo maior lucro.

### 💡 Destaque Técnico
> **Desafio:** Limitações de requisições em lote do plano gratuito da API externa.
>
> **Solução:** A aplicação utiliza **Java Parallel Streams**, permitindo consultas simultâneas e performáticas.
> *(Nota: Implementado com auxílio de IA para otimização da concorrência).*

### 🛠 Tech Stack
* **Linguagem:** Java 21 (Records)
* **Framework:** Spring Boot 4.0.1
* **Comunicação:** Spring RestClient
* **Processamento:** Streams API
