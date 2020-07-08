# Quarkus Microservice Example Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./gradlew quarkusDev
```

## Packaging and running the application

The application can be packaged using `./gradlew quarkusBuild`.
It produces the `quarkus-microservice-1.0.0-SNAPSHOT-runner.jar` file in the `build` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/lib` directory.

The application is now runnable using `java -jar build/quarkus-microservice-1.0.0-SNAPSHOT-runner.jar`.

If you want to build an _über-jar_, just add the `--uber-jar` option to the command line:
```
./gradlew quarkusBuild --uber-jar
```

## Creating a native executable

You can create a native executable using: `./gradlew build -Dquarkus.package.type=native`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./build/quarkus-microservice-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling#building-a-native-executable.

## Install GraalVM using [SdkMan](https://sdkman.io/)

```
sdk list java | grep grl
sdk install java x.y.z-grl
```

Install `native-image`:
```
gu install native-image
```

## Install Minikube 

Read [this](https://minikube.sigs.k8s.io/docs/start/)

## Developer commands

Run as developer:
```
make run
```

Compile jar:
```
make compile
```

Run test:
```
make test
```

## Native commands

Compile native image:
```
make compile-native
```

Run native image:
```
make run-native
```

Run tests as native image:
```
make test-native
```

## Docker commands

Run jvm docker:
```
make docker-run
```

Run native image docker:
```
make docker-run-native
```

## Other commands

Hit default endpoint
```
make hit-greetings
```

Deploy a kubernetes services:
```
make deployment
```

Hit kubernetes service:
```
make hit-k8s-greetings
```

Continuous hit to k8s:
```
make check-k8s-balancing
```

List pods:
```
make watch-k8s-pods 
```