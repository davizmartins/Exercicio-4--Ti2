-- Exercicio 4 - Azure PostgreSQL
-- Autor: Davi Martins


-- 1. Criação do banco
CREATE DATABASE exercicio4;
\c exercicio4;

-- 2. Criação da tabela
CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco NUMERIC(10,2) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    criado_em TIMESTAMP DEFAULT NOW()
);

-- 3. Inserção de dados
INSERT INTO produtos (nome, preco, categoria) VALUES
('Mouse Gamer', 129.90, 'Periféricos'),
('Teclado Mecânico', 349.50, 'Periféricos'),
('Monitor 24"', 899.00, 'Monitores');

-- 4. Consulta final 
SELECT * FROM produtos ORDER BY id;
