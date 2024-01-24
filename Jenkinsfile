pipeline {
    agent any
    tools {
          maven 'maven'
          jdk 'JDK11'
    }
    parameters {
        choice(name: 'AGENT_NODE', choices: ['any'], description: 'Seleccionar NODO')
        choice(name: 'ENV', choices: ['dev', 'uat'], description: 'Selecionar ambiente')
        string(name: 'SCENARIO_TAG', trim: false, description: 'Tag a ejecutar')
    }
    stages {
        stage('Build'){
            steps{
                script{
                    if(isUnix()){
                        sh "java -version"
                        sh "mvn clean install -DskipTests"
                    }
                    else{
                        bat "java -version"
                        sh "mvn clean install -DskipTests"
                    }
                }
            }
        }
        stage('Execute Tests'){
            steps{
                script{
                    try{
                        if(isUnix()){
                           echo "Ejecutando tag: ${params.SCENARIO_TAG}"
                           sh 'mvn clean verify -Dcucumber.filter.tags="${SCENARIO_TAG}"'
                        }
                         else{
                            echo "Ejecutando tag: ${params.SCENARIO_TAG}"
                            bat "java -version"
                            bat 'mvn clean verify -Dcucumber.filter.tags="${params.SCENARIO_TAG}"'
                         }
                    } finally{
                          publishReport();
                    }
                }
            }
        }
    }
}
    def publishReport(){
        publishHTML(target: [
            reportName : 'Serenity Report',
            reportDir:   'target/site/serenity',
            reportFiles: 'index.html',
            keepAll:     true,
            alwaysLinkToLastBuild: true,
            allowMissing: false
        ])
    }