def call () {
    node {
        common.codeQuality()

        if ( branch == "main" || tag ==~ "*" ) {
            stage('style checks') {
                echo 'code Quality'
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