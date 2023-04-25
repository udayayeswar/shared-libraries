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

