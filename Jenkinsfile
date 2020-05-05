#!groovy
pipeline {
    agent none
   stages {     
    stage('Maven Install') {
      agent {         
       docker {          
         image 'maven:3.6.2'         
     }       
  }       
  steps {
       sh 'mvn clean install -DskipTests=true'
       }
     }
   }
 }