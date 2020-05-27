pipeline {
       agent any
   stages {
      stage('Build') {
         steps{
            // Fetch code from a GitHub repository
            git 'https://github.com/panditasagar01/spring-boot-example.git'
            bat 'mvn clean install'
         }
         post {
            // If Maven was able to run the tests, even if some of the test
             // failed, record the test results and archive the jar file.
             success {
                     junit '**/target/surefire-reports/TEST-*.xml'
                     archiveArtifacts 'target/*.jar'
                     }
                  }

      }
      stage('Publish') {
          steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')])
                 {
                    bat 'mvn com.google.cloud.tools:jib-maven-plugin:2.2.0:build'
                 }
          }
      }

   }
}