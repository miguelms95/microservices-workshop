# Makefile for Spring Boot Eureka Server

# Variables
APP_NAME = eureka-server
JAR_FILE = target/$(APP_NAME).jar

# Commands
.PHONY: all clean build run test package stop

all: build run

## Clean - Remove the target directory
clean:
	./mvnw clean

## Build - Compile and build the project
build:
	./mvnw clean package

## Run - Execute the Spring Boot application
run: $(JAR_FILE)
	java -jar $(JAR_FILE)

## Test - Run all tests
test:
	./mvnw test

## Package - Package the application into a jar file
package:
	./mvnw package

## Stop - Stop the running Spring Boot application
stop:
	@pkill -f 'java -jar $(JAR_FILE)' || true

## Help - Show available commands
help:
	@echo "Makefile Commands for Spring Boot Eureka Server"
	@echo ""
	@echo "Usage: make [command]"
	@echo ""
	@echo "Commands:"
	@echo "  all        - Build and run the application"
	@echo "  clean      - Clean the target directory"
	@echo "  build      - Build the project"
	@echo "  run        - Run the Spring Boot application"
	@echo "  test       - Run all tests"
	@echo "  package    - Package the application into a jar file"
	@echo "  stop       - Stop the running application"
	@echo "  help       - Show this help message"

$(JAR_FILE): build
