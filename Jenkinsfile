node {
    stage('Build') {
        echo 'Building....'
	cd 'junitHelper'
	mvn clean install package -DskipTests
	echo 'Building DONE'
    }
    stage('Test') {
        echo 'Testing....'
	cd 'junitHelper'
	mvn test
        echo 'Testing DONE'
    }
    stage('Deploy') {
        echo 'Deploying....'
        echo 'Deploying DONE'
    }
}
