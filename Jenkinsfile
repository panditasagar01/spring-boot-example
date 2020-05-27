pipeline {
       agent any
   stages {
      stage('Fetch GitHub Code') {
         steps {
            // Fetch code from a GitHub repository
            git 'https://github.com/panditasagar01/spring-boot-example.git'
         }

      }
      stage('Build & Docker Push') {
          steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')])
                 {
                    bat 'mvn clean install com.google.cloud.tools:jib-maven-plugin:2.2.0:build'
                 }
          }
      }

   }
}