pipeline {

    agent any

    stages {

        stage('Compile Stage') {
            steps {
                script {
                    def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
                    withEnv(["PATH+MAVEN=${mvnHome}/bin"]) {
                        sh '${mvnHome}/bin/mvn clean compile'
                    }
                }

            }
        }

        stage('Test Stage') {
            steps {
                script {
                    def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
                    withEnv(["PATH+MAVEN=${mvnHome}/bin"]) {
                        sh "${mvnHome}/bin/mvn clean verify -Dcucumber.filter.tags=\"@PRUEBA1\""
                    }
                }
            }

        }

        stage('Cucumber Reports') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                        fileIncludePattern: "**/cucumber.json",
                        jsonReportDirectory: 'target'
            }
        }

    }

}