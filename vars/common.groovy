def codeChecks() {

    if (BRANCH_NAME == "main" || TAG_NAME ==~ ".*") {


        stage('code checkout') {

            git branch: 'main', url: "https://github.com/udayayeswar/${COMPONENT}.git"
            sh "ls"
        }
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
                sonar-scanner -Dsonar.host.url=http://sonar.chaitu.net:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass} -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true ${SONAR_EXTRA_OPTS}
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