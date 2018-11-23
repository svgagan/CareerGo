pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                bat 'mvn clean install -DskipTests' 
                //archiveArtifacts artifacts: '**/target/*.war', fingerprint: true 
                echo 'Building Success'
            }
        }
    }
}
