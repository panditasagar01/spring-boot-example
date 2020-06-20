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
      stage('Build & Run Container') {
          steps {
          bat "docker-compose down"
        //  bat "docker system prune -f"
          bat "docker-compose up -d"
          }
      }
   }
}