run:
	./gradlew quarkusDev

run-native:
	./build/quarkus-microservice-1.0.0-SNAPSHOT-runner

test:
	./gradlew test

test-native:
	./gradlew testNative

compile:
	./gradlew quarkusBuild

compile-native:
	./gradlew build -Dquarkus.package.type=native

hit-greetings:
	curl -s http://localhost:8080/greetings | python -m json.tool

docker-compile: compile
	docker build -f src/main/docker/Dockerfile.jvm -t quarkus/quarkus-microservice-jvm .

docker-run: docker-compile
	docker run -i --rm -p 8080:8080 quarkus/quarkus-microservice-jvm

docker-compile-native: compile-native
	docker build -f src/main/docker/Dockerfile.native -t quarkus/quarkus-microservice .

docker-run-native: docker-compile-native
	docker run -i --rm -p 8080:8080 quarkus/quarkus-microservice

deployment:
	eval $$(minikube docker-env) && make docker-compile-native
	kubectl apply -f kubernetes/quarkus-microservice.yml

hit-k8s-greetings:
	curl -s $(shell minikube service --url quarkus-microservice-service)/greetings | python -m json.tool