node {
    stages {
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
	
	stage('Build') {
	    echo 'Building....'
	    mvn clean install package -DskipTests
	    echo 'Building DONE'
	}
	stage('Test') {
	    echo 'Testing....'
	    sh 'mvn test'
	    echo 'Testing DONE'
	}
    }
}
