def call () {
    pipeline {

        agent any

        stages {

            stage('code quality') {
                steps {
                    echo 'code quality'
                    sh 'env'
                }
            }
            stage('style checks') {
                when {
                    branch 'master'
                }
                steps {
                    echo 'code quality'
                }
            }

            stage('unit tests') {
                when {
                    branch 'master'
                }
                steps {
                    echo 'unit test'
                }
            }


            stage('download dependencies') {
                when { tag "*" }
                steps {
                    echo 'download dependencies'
                }
            }

            stage('prepare artifact') {
                when { tag "*" }
                steps {
                    echo 'prepare artifacts'
                }
            }
            stage('publish artifacts') {
                steps {
                    echo 'publish artifact'
                }
            }
        }
    }
}