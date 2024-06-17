pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "jelty/characters_api:latest"
    }

    stages {
        stage('Checkout') {
            steps {
                // Clona el repositorio de Git
                git 'https://github.com/ThonnyRG/PersonajesAPI'
            }
        }
        
        stage('Build') {
            steps {
                // Construye la imagen Docker
                script {
                    docker.build(DOCKER_IMAGE)
                }
            }
        }
        
        stage('Push') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                        docker.image(DOCKER_IMAGE).push()
                    }
                }
            }
        }
        
        stage('Deploy') {
            steps {
                sh "docker-compose down -v"
                sh "docker-compose up -d --build"
                echo 'Despliegue realizado'
            }
        }
    }
}
