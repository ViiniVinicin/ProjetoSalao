-- SCHEMA: salao

-- DROP SCHEMA IF EXISTS salao ;

CREATE SCHEMA IF NOT EXISTS salao;
SET search_path TO salao;

	-- Tabela Funcionário
CREATE TABLE Funcionario (
    id_funcionario SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    data_admissao DATE
);

-- Tabela Especialização
CREATE TABLE Especializacao (
    id_especializacao SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE
);

-- Tabela de Relacionamento N:N entre Funcionário e Especialização
CREATE TABLE Funcionario_Especializacao (
    id_funcionario INT REFERENCES Funcionario(id_funcionario) ON DELETE CASCADE,
    id_especializacao INT REFERENCES Especializacao(id_especializacao) ON DELETE CASCADE,
    PRIMARY KEY (id_funcionario, id_especializacao)
);

-- Tabela Cliente
CREATE TABLE Cliente (
    id_cliente SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    data_cadastro DATE DEFAULT CURRENT_DATE
);

-- Tabela Serviço
CREATE TABLE Servico (
    id_servico SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    duracao_media INT,  -- Em minutos
    preco DECIMAL(10, 2) NOT NULL
);

-- Tabela Agendamento
CREATE TABLE Agendamento (
    id_agendamento SERIAL PRIMARY KEY,
    id_cliente INT NOT NULL REFERENCES Cliente(id_cliente) ON DELETE CASCADE,
    id_funcionario INT NOT NULL REFERENCES Funcionario(id_funcionario) ON DELETE CASCADE,
    id_servico INT NOT NULL REFERENCES Servico(id_servico) ON DELETE CASCADE,
    data_hora TIMESTAMP NOT NULL,
    status VARCHAR(20) DEFAULT 'Agendado',  -- 'Agendado', 'Concluído', 'Cancelado'
    observacoes TEXT,
    CONSTRAINT check_status CHECK (status IN ('Agendado', 'Concluído', 'Cancelado'))
);

-- Tabela Pagamento (1:1 ou 1:N com Agendamento)
CREATE TABLE Pagamento (
    id_pagamento SERIAL PRIMARY KEY,
    id_agendamento INT NOT NULL REFERENCES Agendamento(id_agendamento) ON DELETE CASCADE,
    valor DECIMAL(10, 2) NOT NULL,
    metodo_pagamento VARCHAR(50),  -- 'Cartão', 'Dinheiro', 'PIX'
    data_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'Pendente',  -- 'Pago', 'Pendente', 'Cancelado'
    CONSTRAINT check_metodo CHECK (metodo_pagamento IN ('Cartão', 'Dinheiro', 'PIX', NULL)),
    CONSTRAINT check_status_pagamento CHECK (status IN ('Pago', 'Pendente', 'Cancelado'))
);


-- População do Banco

-- Especializações
INSERT INTO Especializacao (nome) VALUES 
('Micro Pigmentação'),
('Remoção a Laser'),
('Massagem'),
('Design de Sobrancelha'),
('Extensão de Cílios'),
('Depilação a Laser'),
('Maquiagem');

-- Funcionários
INSERT INTO Funcionario (nome, telefone, email, data_admissao) VALUES 
('Maria Souza', '(11) 9999-8888', 'maria@salao.com', '2023-01-15'),
('João Silva', '(11) 98888-7777', 'joao@salao.com', '2023-02-20');

-- Associar especializações aos funcionários
INSERT INTO Funcionario_Especializacao (id_funcionario, id_especializacao) VALUES 
(1, 1),  -- Maria faz Micro Pigmentação
(1, 7),  -- Maria faz Maquiagem
(2, 5),  -- João faz Extensão de Cílios
(2, 6);  -- João faz Depilação a Laser

-- Serviços
INSERT INTO Servico (nome, descricao, duracao_media, preco) VALUES 
('Micro Pigmentação', 'Técnica de preenchimento de sobrancelhas', 120, 350.00),
('Depilação a Laser', 'Sessão de depilação a laser na perna', 30, 150.00);

-- Clientes
INSERT INTO Cliente (nome, telefone, email) VALUES 
('Ana Lima', '(11) 97777-6666', 'ana@email.com'),
('Carlos Santos', '(11) 96666-5555', 'carlos@email.com');

-- Agendamentos
INSERT INTO Agendamento (id_cliente, id_funcionario, id_servico, data_hora, status) VALUES 
(1, 1, 1, '2024-07-20 14:00:00', 'Agendado'),
(2, 2, 2, '2024-07-21 10:30:00', 'Agendado');

-- Pagamentos
INSERT INTO Pagamento (id_agendamento, valor, metodo_pagamento, status) VALUES 
(1, 350.00, 'PIX', 'Pago'),
(2, 150.00, 'Cartão', 'Pendente');


-- Buscas

-- Todos os clientes
SELECT * FROM salao.Cliente;

-- Todos os agendamentos
SELECT * FROM salao.Agendamento;

-- Nome e telefone dos funcionários
SELECT nome, telefone FROM salao.Funcionario;

-- Nome e preço dos serviços
SELECT nome, preco FROM salao.Servico;


-- Buscas Específicas

-- Nome do Cliente
SELECT 
    a.id_agendamento,
    c.nome AS cliente,
    a.data_hora,
    s.nome AS servico
FROM salao.Agendamento a
JOIN salao.Cliente c ON a.id_cliente = c.id_cliente
JOIN salao.Servico s ON a.id_servico = s.id_servico
WHERE c.nome LIKE '%Ana%'  -- Substituir pelo nome do cliente
ORDER BY a.data_hora DESC;