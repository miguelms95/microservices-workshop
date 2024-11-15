# Deploy

## Requirement

* [kubectl](https://kubernetes.io/docs/tasks/tools/#kubectl)
* [Minikube](https://minikube.sigs.k8s.io/docs/start/)

Here you'll find the scripts to deploy services in k8s.

## Scripts

First: start Minikube cluster: 
```shell
minikube start
```
Second: set Docker environment to use Minikube's Docker daemon
```shell
eval $(minikube docker-env)
```

* [push-docker-images.sh](push-docker-images.sh): push docker images from local docker to minikube
* [deploy.sh](deploy.sh): apply deployments to k8s cluster
* [run-gateway.sh](run-gateway.sh): tunnel for gateway service