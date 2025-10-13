# Exercício 4 – TI2  
## Integração com Banco de Dados e Serviço Cognitivo (Azure + Java)

###  Aluno
**Davi Martins**

---

## Estrutura do Projeto

Exercicio-4--Ti2/
│
├── BANCO/
│ ├── script.SQL # Script SQL com tabelas e inserts
│ ├── print-recurso.png # Print do recurso PostgreSQL criado no Azure
│ └── print-select.png # Print da execução do SELECT no banco remoto
│
├── Cognitivo/
│ ├── print-api-ai.png # Print do recurso de IA criado no Azure
│ ├── print-resultado-final-ai # Print da execução da API de Análise de Sentimentos
│ └── ex4-cognitivo/ # Projeto Maven (Java)
│ ├── pom.xml
│ └── src/
│ └── main/java/br/com/ex4/App.java
│── print-tela azure.png # Print do cadastro e vinculação com a AZURE
└── README.md 

---

## ☁️ Banco de Dados (PostgreSQL no Azure)

- Criado um **Azure Database for PostgreSQL** (Single Server).  
- Configuração de **usuário e senha** feita conforme orientações do professor.  
- Tabelas criadas e populadas a partir do `script.SQL`.  
- Conexão testada via **Azure Data Studio** (print em `BANCO/print-select.png`).

---

## 🧠 Serviço Cognitivo (Azure AI)

- Criado um **recurso Multi-service** no Azure chamado `ai-ex04`.  
- Configuração com acesso de rede em **“Todas as redes”**.  
- Utilizada a API `https://ai-ex04.cognitiveservices.azure.com/language/:analyze-text?api-version=2023-04-01`.

### 🔑 Variável de ambiente utilizada:
AZURE_AI_KEY = [Key 1 do recurso AI]

O projeto demonstra a integração completa entre:

Banco de dados PostgreSQL hospedado no Azure

Serviço Cognitivo de Análise de Sentimentos via Java + Maven

Essa integração comprova o domínio dos conceitos de APIs REST, cloud computing e desenvolvimento backend em Java com consumo de serviços externos.
