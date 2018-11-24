pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                bat 'mvn clean' 
                //archiveArtifacts artifacts: '**/target/*.war', fingerprint: true 
                echo 'Building Success'
            }
        }
    }
}
