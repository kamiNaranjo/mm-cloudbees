library 'kypseli'
pipeline {
  options { 
    skipDefaultCheckout()
    buildDiscarder(logRotator(numToKeepStr: '5')) 
    disableConcurrentBuilds()
  }
  agent none
  stages {
          stage('Docker Build and Push') {
          agent none
        //checkpoint 'Before Docker Build and Push'
          steps {
            dockerBuildPush('beedemo/cje-mm', 'kaniko-1','./') {
              git branch: 'kube-test', credentialsId: 'kypseli-github-token', poll: false, url: 'https://github.com/kypseli/cje-mm.git' 
            }
          }
        }
  }
}
