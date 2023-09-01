pipeline {
    agent any

    parameters {
        choice(name: 'SCENARIO_PARAM', choices: ['End to End', 'End to End Claim Investigation'], description: 'Which Feature to Run')
    }

    stages {
        stage('Install Dependencies') {
            steps {
                // Menginstal dependensi proyek menggunakan Maven
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    if (params.SCENARIO_PARAM == 'End to End' || params.SCENARIO_PARAM == 'End to End Claim Investigation') {
                        // Gunakan nilai SCENARIO_PARAM untuk menjalankan tes yang sama
                        bat "\"C:\\Program Files\\apache-maven-3.8.8\\bin\\mvn\" clean test -Dtest=runner.TestRunner1 -Dcucumber.filter.tags=@FirstScenarios"
                    } else {
                        // Lakukan sesuatu jika opsi lainnya dipilih
                    }
                }
            }
        }
    }
}
