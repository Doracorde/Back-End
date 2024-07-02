# Use uma imagem base do OpenJDK
FROM openjdk:17-jdk-alpine

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR gerado para a imagem
COPY target/cadastro-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta que a aplicação usará
EXPOSE 8081

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
