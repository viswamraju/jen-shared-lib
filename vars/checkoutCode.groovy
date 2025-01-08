def call(String repoUrl, String branch){
    def workingDir = "${env.WORKSPACE}/rand"
    sh "rm -rf ${workingDir}"
    sh "mkdir -p ${workingDir}"
    sh "git clone ${repoUrl} ${workingDir}"
    sh "git checkout ${branch}"
    return workingDir
}