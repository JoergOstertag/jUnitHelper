node {
    stages {

	stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }

	stage('compile') {
	    steps {
	    	sh 'mvn clean install'
	    	}
	}

	stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
	
	
    }
}
