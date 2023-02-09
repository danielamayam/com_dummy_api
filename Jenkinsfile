pipeline {
    agent any
    stages {
        stage('Clonar repositorio') {
            steps {
                git url: 'https://github.com/danielamayam/com_dummy_api.git', branch: 'main'
            }
        }
    stage('Compilación') {
                steps {
                    echo ("./gradlew build")
                }
            }
    stage('Test') {
                steps {
                    script {
                        try {
                            bat("gradle clean test aggregate")
                            echo 'Ejecucion exitosa de las pruebas'

                        } catch (e) {
                            echo 'Pruebas fallidas'

                        }
                    }
                }
            }
        }
    }