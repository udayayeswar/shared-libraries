def call () {
    node (env.RUNNER)
        {
            common.codeCheckout()
            common.codeQuality()
            common.codeChecks
            common.artifacts()

        }

    }



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