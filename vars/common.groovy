def codeCheckout() {

    if (BRANCH_NAME == "main" || TAG_NAME ==~ ".*") {


        stage('code checkout') {
//            sh 'find . | sed 1d |xargs rm -rf'
            git branch: 'main', url: "https://github.com/chaitanyachandra/${COMPONENT}.git"

        }


    }
}


def codeQuality() {
    stage('code quality') {
        withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
            sh '''
              echo "codequality"
                sonar-scanner -Dsonar.host.url=http://sonar.chaitu.net:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass} -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true ${SONAR_EXTRA_OPTS}
              '''
        }
        }
    }
def codeChecks() {
    if (env.BRANCH_NAME == "main" || env.TAG_NAME ==~ ".*") {


        stage('style checks') {
            echo 'style checks'
        }

        stage('unit test') {
            echo 'unit Test'
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