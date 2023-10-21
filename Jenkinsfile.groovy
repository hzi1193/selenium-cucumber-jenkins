pipeline {

    agent any

    stages {

        stage('Compile Stage') {

            steps {
                withMaven('manven_3_9_5') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Test Stage') {
            steps {
                withMaven('manven_3_9_5') {
                    sh 'mvn clean verify -Dcucumber.filter.tags="@PRUEBA1"'
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