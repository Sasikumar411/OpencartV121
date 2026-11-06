
pipeline {

    agent any

    tools {
        jdk 'MyJava'
        maven 'MyMaven'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code from GitHub'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Compiling Maven project'
                sh 'mvn clean compile'
            }
        }

        stage('Execute Tests') {
            steps {
                echo 'Executing Selenium automation tests'
                sh 'mvn test'
            }
        }
    }

    post {

        always {
            echo 'Test execution completed'

            junit allowEmptyResults: true,
                  testResults: '**/target/surefire-reports/*.xml'

            archiveArtifacts artifacts: '**/target/surefire-reports/*',
                             allowEmptyArchive: true
        }

        success {
            echo 'Build completed successfully!'
        }

        failure {
            echo 'Build failed. Please check console output.'
        }
    }
}
