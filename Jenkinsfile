pipeline {
   agent any
   stages {

      stage ('Build') {
         steps {
            sh "rm -rf build/libs/"
            sh "chmod +x gradlew"
            sh "./gradlew build curseforge"

            archiveArtifacts artifacts: '**/build/libs/*.jar'
         }
      }
   }
}