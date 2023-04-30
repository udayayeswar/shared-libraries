def codeCheckout() {

    if (BRANCH_NAME == "main" || TAG_NAME ==~ ".*") {


        stage('code checkout') {
//            sh 'find . | sed 1d |xargs rm -rf'
            git branch: 'main', url: "https://github.com/udayayeswar/${COMPONENT}.git"

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
    if (env.TAG_NAME ==~ ".*") {

        stage('Prepare Artifacts') {
            if (env.APPTYPE == "nodejs") {
                sh '''
          npm install 
          zip -r ${COMPONENT}-${TAG_NAME}.zip node_modules index.js views public model
        '''
            }


            if (env.APPTYPE == "java") {
                sh '''
          mvn clean package 
          mv target/status-1.0-SNAPSHOT.jar ${COMPONENT}-1.0-SNAPSHOT.jar 
          zip -r ${COMPONENT}-${TAG_NAME}.zip ${COMPONENT}-1.0-SNAPSHOT.jar
        '''
            }
        }


    }
}