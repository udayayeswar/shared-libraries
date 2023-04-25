def call () {
    node {
        sh 'env'
        common.codeQuality()

        if ( BRANCH_NAME == "main" || TAG_NAME ==~ ".*" ) {
            stage('style checks') {
                echo 'style checks'
            }
        }
    }
    }

//            stage('style checks') {
//                when {
//                    branch 'master'
//                }
//                steps {
//                    echo 'code quality'
//                }
//            }
//
//            stage('unit tests') {
//                when {
//                    branch 'master'
//                }
//                steps {
//                    echo 'unit test'
//                }
//            }
//
//
//            stage('download dependencies') {
//                when { tag "*" }
//                steps {
//                    echo 'download dependencies'
//                }
//            }
//
//            stage('prepare artifact') {
//                when { tag "*" }
//                steps {
//                    echo 'prepare artifacts'
//                }
//            }
//            stage('publish artifacts') {
//                steps {
//                    echo 'publish artifact'
//                }
//            }
//        }
//    }
//}