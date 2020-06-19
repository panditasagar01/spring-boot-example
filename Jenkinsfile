//def CONTAINER_NAME="boot-demo-repo"
//def CONTAINER_TAG="latest"
//def DOCKER_HUB_USER="sagar16nov"
//def HTTP_PORT="9090"
pipeline {
environment{
def customImage =''
}
       agent any
   stages {
      stage('Build') {
         steps{
            // Fetch code from a GitHub repository
            git 'https://github.com/panditasagar01/spring-boot-example.git'
            bat 'mvn clean install'
         }
      }
      stage('Build Docker Image') {
          steps {
                 script {
                         customImage = docker.build("boot-image:${env.BUILD_ID}")
                         //customImage.push()
                        }
                        bat label: '', script: 'docker save customImage > exportcustomImage.tar'
          }
      }
   }
}