pipeline {
       agent any
         parameters {
           choice(name: 'DEPLOY_ENV_LVL', choices:'dev\nqa\nprd', description: 'The target environment level' )
         }
   stages {
      stage('Build') {
         steps{
            echo "DEPLOY_ENV_LVL: ${params.DEPLOY_ENV_LVL}"
                        // Fetch code from a GitHub repository
                     if("${DEPLOY_ENV_LVL}" == "dev"){
                         git 'https://github.com/panditasagar01/spring-boot-example.git', branch: "master"
                     }

            bat 'mvn clean install'
         }
      }
      stage('Run Docker Container') {
          steps {
          bat "docker-compose down"
          bat "docker system prune -f"
          bat "docker-compose up -d"
          }
      }
   }
}