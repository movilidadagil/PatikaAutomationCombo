node {
  checkout scm
  env.PATH = "${tool 'maven-3.5.2'}/bin:${env.PATH}"
  stage('Package') {
    dir('.') {
      sh 'mvn clean package -DskipTests'
    }
  }

  stage('Create Docker Image') {
    dir('.') {
      docker.build("PatikaAutomationCombo:${env.BUILD_NUMBER}")
    }
  }

  stage ('Run Application') {
    try {

      // Run application using Docker image

      // Run tests using Maven
      dir ('.') {
        sh 'mvn exec:java -DskipTests'
      }
    } catch (error) {
    } finally {
      // Stop and remove database container here
      //sh 'docker-compose stop db'
      //sh 'docker-compose rm db'
    }
  }

  stage('Run Tests') {
    try {
      dir('.') {
        sh "mvn test"
             docker.build("PatikaAutomationCombo:${env.BUILD_NUMBER}").push()
      }
    } catch (error) {

    } finally {
      junit '**/target/surefire-reports/*.xml'
    }
  }
}