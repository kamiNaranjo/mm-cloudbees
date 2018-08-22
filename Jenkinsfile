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
            dockerBuildPush('946759952272.dkr.ecr.us-east-1.amazonaws.com/kypseli/cb-core-mm', '2.121.3.1-5','./') {
              git branch: 'kube-workshop', credentialsId: 'kypseli-github-token', poll: false, url: 'https://github.com/kypseli/cje-mm.git' 
            }
          }
        }
  }
}
