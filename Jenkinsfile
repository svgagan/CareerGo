pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                sh 'mvn clean install -DskipTests' 
                //archiveArtifacts artifacts: '**/target/*.war', fingerprint: true 
                echo 'Building Success'
            }
        }
    }
}
