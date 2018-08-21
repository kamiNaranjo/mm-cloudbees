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
            dockerBuildPush('beedemo/cloudbees-core-mm', '2.121.3.1-1-kypseli','./') {
              git branch: 'kube-workshop', credentialsId: 'kypseli-github-token', poll: false, url: 'https://github.com/kypseli/cje-mm.git' 
            }
          }
        }
  }
}
