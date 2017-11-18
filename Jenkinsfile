node {
    stage("checkout") {
        git branch: 'development', url: 'https://github.com/Diluv/Inquisitor'
    }

    stage("build") {
        sh './gradlew clean build'
    }

    stage("deploy") {
        sh './gradlew uploadArchives'
    }
}