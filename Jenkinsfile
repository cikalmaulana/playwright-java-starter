pipeline {
    agent any

    parameters {
        string(name: 'KEYWORDS_PARAM', description: 'Comma-separated list of keywords')
        string(name: 'IS_IMAGE_PARAM', description: 'Whether to use images')
        choice(name: 'WHICH_FEATURE', choices: ['firstTest', 'secondTest', 'thirdTest'], description: 'Which Feature to Run')
    }

    stages {
        stage('Checkout') {
            steps {
                // Mengambil kode dari repositori GitHub
                checkout([$class: 'GitSCM',
                          branches: [[name: '*/main']], // Ganti "main" dengan nama cabang yang benar
                          userRemoteConfigs: [[url: 'https://github.com/cikalmaulana/playwright-java-starter.git']]])
            }
        }

        stage('Install Dependencies') {
            steps {
                // Menginstal dependensi proyek menggunakan Maven
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    def workspacePath = pwd() // Mendapatkan jalur direktori kerja Jenkins
                    def selectedFeature = params.WHICH_FEATURE
                    echo "Selected feature: ${selectedFeature}"

                    def runnerValue = ""
                    switch (selectedFeature) {
                        case 'firstTest':
                            runnerValue = "TestRunner1"
                            break
                        case 'secondTest':
                            runnerValue = "TestRunner2"
                            break
                        case 'thirdTest':
                            runnerValue = "TestRunner3"
                            break
                        default:
                            echo "Invalid choice"
                            break
                    }

                    if (runnerValue) {
                        bat "${workspacePath}\\mvn clean test -Drunner.include=${runnerValue}"
                    }
                }
            }
        }


        stage('Generate Reports') {
            steps {
                script {
                    step([$class: 'CucumberReportsPublisher',
                          jsonReportDirectory: '**/*.json',
                          ignoredFailedTests: true,
                          outputDirectory: 'target/cucumber-reports'])
                }
            }
        }
    }
}
