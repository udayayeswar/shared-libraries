def codeChecks() {

    if (BRANCH_NAME == "main" || TAG_NAME ==~ ".*") {

        stage('style checks') {
            echo 'style checks'
        }

        stage('unit test')
        echo 'unit Test'

    }
}


def codeQuality () {
    stage('code quality') {
        withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
            sh '''
              echo "codequality"
              /opt/sonar-scanner/bin/sonar-scanner -Dsonar.host.url=http://172.16.3.114:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass}  -Dsonar.projectKey=node-app -Dsonar.qualitygate.wait=true
            '''
        }
        }
    }

def artifacts() {
    if (BRANCH_NAME == "demo") {

        stage('Download Dependences') {
                echo 'Download Dependences'
            }

            stage('Prepare Artifacts') {
                echo 'Prepare Artifacts'
            }
            stage('Publish Artifacts') {
                echo 'Publish Artifacts'
            }
        }
    }