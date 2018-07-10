library 'kypseli'
pipeline {
  options { 
    buildDiscarder(logRotator(numToKeepStr: '5')) 
    disableConcurrentBuilds()
  }
  agent none
  stages {
          stage('Docker Build and Push') {
          agent none
        //checkpoint 'Before Docker Build and Push'
          steps {
            dockerBuildPush('beedemo/cje-mm', 'kaniko-1', '.') {
              //nothting to do here
            }
          }
        }
  }
}
