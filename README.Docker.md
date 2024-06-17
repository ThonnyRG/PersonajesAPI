# Docker Configuration for Spring Boot Application

This project includes Docker configuration for building and running your Spring Boot application in a containerized environment.

## Files

- **Dockerfile**: Defines the Docker image for the application.
- **.dockerignore**: Specifies files and directories to be ignored by Docker.
- **docker-compose.yaml**: Defines services, networks, and volumes for multi-container Docker applications.

## Building and Running the Application

### Build the Docker Image

To build the Docker image for your Spring Boot application, run the following command:

```bash
docker build -t characters-app .