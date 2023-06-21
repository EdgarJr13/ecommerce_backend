CREATE TABLE IF NOT EXISTS produto (
    id INT AUTO_INCREMENT,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    valor DECIMAL(10,2),
    PRIMARY KEY (id)
    );

INSERT INTO produto (nome, descricao, valor) VALUES ('Blusa Time A', 'Blusa principal do Time A', 150.0);
INSERT INTO produto (nome, descricao, valor) VALUES ('Blusa Time B', 'Blusa visitante do Time B', 160.0);

