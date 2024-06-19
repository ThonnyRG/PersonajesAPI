# PersonajesAPI

Este proyecto es una API REST para gestionar personajes, construida con Spring Boot y MongoDB. El pipeline de Jenkins se utiliza para la integración y despliegue continuo (CI/CD).

## Contenido

- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Ejecutar la Aplicación](#ejecutar-la-aplicación)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Docker](#docker)
- [Pipeline de Jenkins](#pipeline-de-jenkins)
- [Pruebas](#pruebas)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Requisitos

- Java 17+
- Maven 3.6+
- Docker
- MongoDB
- Jenkins

## Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/ThonnyRG/PersonajesAPI.git
    cd PersonajesAPI
    ```

2. Configura MongoDB:
    - Asegúrate de que MongoDB esté instalado y en funcionamiento.

3. Configura las dependencias:
    ```sh
    mvn clean install
    ```

## Ejecutar la Aplicación

Puedes ejecutar la aplicación localmente usando Maven:

```sh
mvn spring-boot:run
La aplicación estará disponible en http://localhost:8080.
```
## Docker
Para construir y ejecutar la aplicación utilizando Docker, sigue los siguientes pasos:

Construir la imagen Docker:

```sh
docker build -t jelty/characters_api .
```
Ejecutar el contenedor Docker:

```sh
docker run -p 8080:8080 jelty/characters_api
```
## Pipeline de Jenkins
Este proyecto incluye un Jenkinsfile que define un pipeline de Jenkins para la integración continua y el despliegue continuo (CI/CD). El pipeline realiza las siguientes etapas:

Checkout: Clona el repositorio desde GitHub.
Build: Compila el proyecto utilizando Maven.
Test: Ejecuta las pruebas unitarias y publica los resultados.
Build Docker Image: Construye la imagen Docker utilizando el Dockerfile.
Push Docker Image: Sube la imagen Docker a Docker Hub.
Deploy: Despliega la aplicación en un clúster de Kubernetes.
Configuración de Jenkins
Configurar las Credenciales de Docker Hub en Jenkins:

Ve a "Manage Jenkins" -> "Manage Credentials".
Añade nuevas credenciales de tipo "Username with password" con tu nombre de usuario y contraseña de Docker Hub.
Asigna un ID reconocible, como dockerhub-credentials-id.
Configurar Jenkins para usar el Pipeline:

Crea un nuevo pipeline en Jenkins.
Configura el pipeline para que use el Jenkinsfile del repositorio.
Diagrama del Pipeline

### Despliegue
La aplicación se despliega en un clúster de Kubernetes utilizando kubectl. Asegúrate de que kubectl esté configurado correctamente en el servidor de Jenkins y tenga acceso al clúster de Kubernetes.

Diagrama de Despliegue

## Pruebas
Las pruebas unitarias están incluidas en el proyecto y pueden ejecutarse con Maven:

```sh
mvn test
Los resultados de las pruebas se publican en target/surefire-reports.
```
## Contribuciones
¡Las contribuciones son bienvenidas! Por favor, abre un issue o un pull request para discutir cualquier cambio que desees realizar.

## Licencia
Este proyecto está licenciado bajo la Licencia MIT
