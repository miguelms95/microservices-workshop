# Makefile for Spring Boot app

help: ## show make targets
	@awk 'BEGIN {FS = ":.*?## "} /[a-zA-Z_-]+:.*?## / {sub("\\\\n",sprintf("\n%22c"," "), $$2);printf " \033[36m%-20s\033[0m  %s\n", $$1, $$2}' $(MAKEFILE_LIST)

clean: ## Clean - Remove the target directory
	./mvnw clean

build: ## Build - Compile and build the project
	./mvnw clean package

run: ## Run - Execute the Spring Boot application
	mvn spring-boot:run

test: ## Test - Run all tests
	./mvnw test

package: ## Package - Package the application into a jar file
	./mvnw package

docker-build:
	docker build -t eureka-server .

docker-run: docker-build ## run docker image
	 docker run --rm --name eureka-server-1 -p 8761:8761 eureka-server

docker-stop: ## stop docker image
	docker stop eureka-server-1

.PHONY: clean build run test package