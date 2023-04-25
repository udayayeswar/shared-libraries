def codeQuality () {
    stage('code quality') {
        echo 'code quality'
        }
    }
def codeChecks() {
    if ( BRANCH_NAME == "main" || TAG_NAME ==~ ".*" ) {

        stage('style checks') {
            echo 'style checks'
        }

        stage('unit test')
           echo 'unit Test'

    }
}

def artifacts() {
    if ( BRANCH_NAME == "demo" ) {

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