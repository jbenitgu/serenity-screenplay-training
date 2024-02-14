pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'JDK11'
    }
    parameters {
        choice(name: 'ENV', choices: ['dev', 'uat'], description: 'Seleccionar ambiente')
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
                        bat "mvn clean install -DskipTests"
                    }
                }
            }
        }
        stage('Execute Tests'){
            steps{
                script{
                    try{
                        if(isUnix()){
                            echo "Executing tag: ${params.SCENARIO_TAG}"
                            sh 'mvn clean verify -Dcucumber.filter.tags="${SCENARIO_TAG}"'
                            def htmlFileName = sh(script: 'ls target/site/serenity/*s.html | head -n 1 | xargs -n 1 basename', returnStdout: true).trim()
                            env.HTML_FILE_NAME = htmlFileName
                            echo env.HTML_FILE_NAME
                        }
                        else {
                            echo "Executing tag: ${params.SCENARIO_TAG}"
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
            reportName: 'Serenity Report',
            reportDir: 'target/site/serenity',
            reportFiles: env.HTML_FILE_NAME,
            keepAll: true,
            alwaysLinkToLastBuild: true,
            allowMissing: false
        ])
    }