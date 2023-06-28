#Imagem base que possui o Java Instalado
FROM openjdk:17-jdk-slim

# Definindo o diretório de trabalho dentro do container
WORKDIR /app

# Copiando o arquivo .jar compilado para dentro do container
COPY target/ecommerce-backend-0.0.1-SNAPSHOT.jar app.jar

# Porta utilizada para rodar a aplicação
EXPOSE 8080

# Inicialização da aplicação no ato da execução do container
CMD java -jar app.jar