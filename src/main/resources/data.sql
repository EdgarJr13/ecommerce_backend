CREATE TABLE IF NOT EXISTS produto (
    id INT AUTO_INCREMENT,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    valor DECIMAL(10,2),
    PRIMARY KEY (id)
    );

INSERT INTO produto (nome, descricao, valor) VALUES
    ('Placa-mãe Modelo X', 'Placa-mãe avançada para processadores Intel e AMD', 299.99),
    ('Processador Intel Core i7', 'Processador de última geração com 8 núcleos e 16 threads', 449.99),
    ('Memória RAM DDR4 16GB', 'Módulo de memória RAM DDR4 com capacidade de 16GB', 129.99),
    ('SSD 500GB', 'Unidade de estado sólido com capacidade de 500GB', 99.99),
    ('Placa-mãe Modelo Y', 'Placa-mãe de alto desempenho para gamers', 349.99),
    ('Processador AMD Ryzen 5', 'Processador de última geração com 6 núcleos e 12 threads', 299.99),
    ('Memória RAM DDR4 8GB', 'Módulo de memória RAM DDR4 com capacidade de 8GB', 79.99),
    ('SSD 1TB', 'Unidade de estado sólido com capacidade de 1TB', 199.99),
    ('Placa-mãe Modelo Z', 'Placa-mãe para servidores de alta performance', 599.99),
    ('Processador Intel Core i9', 'Processador de última geração com 10 núcleos e 20 threads', 699.99),
    ('Memória RAM DDR4 32GB', 'Módulo de memória RAM DDR4 com capacidade de 32GB', 249.99),
    ('SSD 2TB', 'Unidade de estado sólido com capacidade de 2TB', 399.99),
    ('Windows 10', 'Sistema operacional da Microsoft', 149.99),
    ('Placa de vídeo GeForce RTX 3080', 'Placa de vídeo de alto desempenho para jogos', 799.99),
    ('Adobe Photoshop', 'Software de edição de imagens profissional', 249.99),
    ('Memória RAM DDR4 32GB', 'Módulo de memória RAM DDR4 com capacidade de 32GB', 249.99),
    ('SSD 2TB', 'Unidade de estado sólido com capacidade de 2TB', 399.99),
    ('Adobe Premiere Pro', 'Software de edição de vídeos profissional', 299.99),
    ('Placa de som externa', 'Dispositivo para melhorar a qualidade de áudio', 79.99),
    ('Microsoft Office 365', 'Pacote de aplicativos de escritório da Microsoft', 9.99),
    ('Razer DeathAdder Elite', 'Mouse gamer com sensor óptico avançado', 59.99),
    ('The Sims 4', 'Simulador de vida virtual', 39.99),
    ('Forza Horizon 5', 'Jogo de corrida em mundo aberto', 59.99),
    ('FIFA 23', 'Jogo de futebol', 69.99);