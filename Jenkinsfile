def CONTAINER_NAME="boot-demo-repo"
def CONTAINER_TAG="latest"
def DOCKER_HUB_USER="sagar16nov"
def HTTP_PORT="9090"
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
             // failed, record the test results.
             success {
                     junit '**/target/surefire-reports/TEST-*.xml'
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
      stage('Run Application') {
          steps{
              bat "docker pull $DOCKER_HUB_USER/$CONTAINER_NAME"
              bat "docker run -d --rm -p $HTTP_PORT:8085 --name $CONTAINER_NAME $DOCKER_HUB_USER/$CONTAINER_NAME:$CONTAINER_TAG"
              echo "Application started on port: ${HTTP_PORT} (http)"
          }
      }

   }
}