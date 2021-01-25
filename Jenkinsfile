node {
    stage('Build') {
        echo 'Building....'
	mvn clean install package -DskipTests
	echo 'Building DONE'
    }
    stage('Test') {
        echo 'Testing....'
	mvn test
        echo 'Testing DONE'
    }
    stage('Deploy') {
        echo 'Deploying....'
        echo 'Deploying DONE'
    }
}
