pipeline {
    agent any 
    stages {
        stage ('scm') {
            steps {
                script {
                    checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/chaiithu/chaithu--.ear.git']])
                }
            }
        }
        stage ('build') {
            steps {
                script {
                    sh'''mvn clean package'''
                }
            }
        }
        stage ('image build and tag') {
            steps {
                script {
                    sh'''docker build -t chaithu .
                         docker tag chaithu chaithuchaithanya/ear
                         '''
                }
            }
        }
        stage ('push') {
            steps {
                script {
                    withDockerRegistry(credentialsId: 'docker_cred', url: '') {
                        sh'''docker push chaithuchaithanya/ear'''
                    }
                }
            }
        }
        stage ('deploy') {
            steps {
                script {
                    sh'''docker run -d -p 8090:8080 --name poori chaithu'''
                }
            }
        }
    }
}