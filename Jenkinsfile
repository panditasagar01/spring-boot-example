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
          bat 'docker-compose –f docker-compose.yml UP'
                // script {
                       // bat 'deploy.sh'
                         //customImage = docker.build("boot-image:${env.BUILD_ID}")
                         //customImage.push()
                       // }
                        //bat label: '', script: 'docker save customImage > exportcustomImage.tar'
          }
      }
   }
}