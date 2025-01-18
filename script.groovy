pipeline {
    agent any
    stages {
        stage('Checkout Repository') {
            steps {
                checkout scm
            }
        }
        stage('Compile and Run C++') {
            steps {
                bat '''
                g++ -o program program.cpp
                program
                '''
            }
        }
    }
}
