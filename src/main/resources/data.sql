-- Criar uma tabela de usuários
CREATE TABLE IF NOT EXISTS Usuario (
                                     id SERIAL PRIMARY KEY,
                                     nome VARCHAR(50) NOT NULL,
                                     cpf VARCHAR(100) NOT NULL
);

-- Inserir dados iniciais na tabela de usuários
INSERT INTO Usuario (nome, cpf) VALUES ('user1', '12345678910');
INSERT INTO Usuario (nome, cpf) VALUES ('user2', '12345678910');