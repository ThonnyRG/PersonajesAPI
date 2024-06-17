pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "jelty/characters_api:latest"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Despliegue realizado'
            }
        }
        
        stage('Build') {
            steps {
                script {
                    echo 'Despliegue realizado'
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
                echo 'Despliegue realizado'
            }
        }
    }
}
