# Usa una imagen base de OpenJDK
FROM openjdk:21-slim

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR al contenedor
COPY /characters CharactersApplication.java

# Especifica el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-java", "CharactersApplication.java"]
