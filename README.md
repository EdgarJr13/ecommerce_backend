# Ecommerce Backend

Este é o backend do sistema de ecommerce desenvolvido por mim como parte do desafio SuperSim Challenge. Ele fornece uma API RESTful para gerenciar produtos e pedidos.

## Configuração

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- Java Development Kit (JDK) 17 ou superior
- Apache Maven

## Executando o projeto localmente

1. Clone este repositório em sua máquina local.
git clone https://github.com/EdgarJr13/ecommerce_backend.git

2. Navegue até o diretório do projeto.
cd ecommerce-backend

3. Execute o seguinte comando para construir a imagem Docker do projeto.
docker build -t ecommerce-backend .

4. Após a conclusão da construção da imagem, execute o contêiner Docker com o seguinte comando:
docker run -p 8080:8080 ecommerce-backend

5. O backend estará sendo executado na porta 8080 do contêiner Docker, que foi mapeada para a porta 8080 do seu host local. Você pode acessar a API RESTful em http://localhost:8080/api.

## Endpoints da API

A API oferece os seguintes endpoints para interagir com a aplicação:

- `GET /api/produtos`: Retorna todos os produtos cadastrados.
- `POST /api/produtos/novo_produto`: Cria um novo produto.
- `GET /api/produtos/buscar`: Busca produtos que contenham o termo inserido como parâmetro.
- `GET /api/produtos/obter_produto_id/{id}`: Retorna um produto específico com base no ID.
- `PUT /api/produtos/atualizar_produto/{id}`: Atualiza um produto existente com base no ID.
- `DELETE /api/produtos/deletar_produto/{id}`: Exclui um produto com base no ID.

## Tecnologias utilizadas

- Java
- Spring Boot
- Docker

## Implementações futuras
Devido ao tempo para entrega do projeto, alguns estudos meus não foram aplicados pois não haveria tempo hábil para os mesmos. As implementações seriam:

- Implementação do Amazon Web Services para upload de imagens referentes aos produtos cadastrados no banco de dados. Insisti um pouco nessa funcionalidade pois achei que somaria consideravelmente na experiência do usuário, mas infelizmente o projeto estava se mostrando incompatível com o mesmo e não havia tempo hábil para focar somente nisso. Acredito que três dias seriam suficientes para estudar a tecnologia mais à fundo, permitindo que fosse implementada da forma correta.
- A implementação de uma funcionalidade para registrar pedidos pretendidos pelos usuários, a fim de juntar vários produtos do interesse do usuário para uma lista, assim como há essa possibilidade no site em que este sistema foi inspirado (Boa Dica). Acredito que um dia seria suficiente para a mesma.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir um pull request com melhorias, correções de bugs ou novos recursos.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
