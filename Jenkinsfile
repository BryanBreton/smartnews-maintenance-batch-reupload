#!groovy
@Library('gie') _

k8sContinuousDeployment(
        builder: 'mvn',
        commercialName: 'smartnews-maintenance-batch',
        imageForBuild: 'docker-registry-iris.groupement.systeme-u.fr/iris-factory/mvn:3.6.3-jdk11',
        authProvider: 'none',
        contextRoot: 'smartnews-maintenance-batch-v1',
        allowManualDeployment: true,
        slackChannel: 'smartnews-stream',
        kubernetesDeployer: [
                namespace: 'smartnews',
                manifestRepository: 'https://github.com/ugieiris/k8s-deploy-ded-ge-rhc.git',
                integration     : [
                        cluster: 'dev-gke-app'
                ],
                recette         : [
                        cluster: 'rec-gke-app'
                ],
                production      : [
                        cluster: 'prod-gke-app'
                ]
        ]
)