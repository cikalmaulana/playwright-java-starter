pipeline {
    agent any

    parameters {
        string(name: 'KEYWORDS_PARAM', description: 'Comma-separated list of keywords')
        string(name: 'IS_IMAGE_PARAM', description: 'Whether to use images')
        choice(name: 'SCENARIO_PARAM', choices: ['End to End', 'End to End Claim Investigation'], description: 'Which Feature to Run')
        string(name: 'POLICY', description: 'Policy Number', defaultValue: '', trim: true)
        string(name: 'DOB', description: 'Date of Birth', defaultValue: '', trim: true)
    }

    stages {

        stage('Install Dependencies') {
            steps {
                // Menginstal dependensi proyek menggunakan Maven
                bat 'mvn clean install'
            }
        }

        stage('Trigger Another Job') {
            steps {
                script {
                    if (params.SCENARIO_PARAM == 'End to End') {
                        input message: 'Please enter the Policy Number', parameters: [
                            string(name: 'POLICY', defaultValue: '', trim: true)
                        ]
                    } else if (params.SCENARIO_PARAM == 'End to End Investigation') {
                        input message: 'Please enter the Date of Birth', parameters: [
                            string(name: 'DOB', defaultValue: '', trim: true)
                        ]
                    }
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    def workspacePath = pwd() // Mendapatkan jalur direktori kerja Jenkins
                    def selectedFeature = params.WHICH_FEATURE
                    echo "Selected feature: ${selectedFeature}"
                    switch (params.WHICH_FEATURE) {
                        case 'firstTest':
                            bat "\"C:\\Program Files\\apache-maven-3.8.8\\bin\\mvn\" clean test -Dtest=runner.TestRunner1 -Dcucumber.filter.tags=@FirstScenarios"
                            break
                        case 'secondTest':
                            bat "\"C:\\Program Files\\apache-maven-3.8.8\\bin\\mvn\" clean test -Dtest=runner.TestRunner2 -Dcucumber.filter.tags=@SecondScenarios"
                            break
                        case 'thirdTest':
                            bat "\"C:\\Program Files\\apache-maven-3.8.8\\bin\\mvn\" clean test -Dtest=runner.TestRunner3 -Dcucumber.filter.tags=@ThirdScenarios"
                            break
                        default:
                            echo "Invalid choice"
                            break
                    }
                }
            }
        }
    }
}
