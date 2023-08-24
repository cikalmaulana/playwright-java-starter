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

                    script {
                        def selectedFeature = params.WHICH_FEATURE
                        echo "Selected feature: ${selectedFeature}"

                        switch (selectedFeature) {
                            case 'firstTest':
                                echo "Running firstTest"
                                break
                            case 'secondTest':
                                echo "Running secondTest"
                                break
                            case 'thirdTest':
                                echo "Running thirdTest"
                                break
                            default:
                                echo "Invalid choice"
                                break
                        }
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
