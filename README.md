# Getting Started

### Run the application
```shell
mvn spring-boot:run
```

### Run the tests
```shell
mvn test
```

### Build the application
```shell
mvn clean package
```

### Build the Docker image from Dockerfile
```shell
docker build -t sbapi:latest .
```

### Run the Docker image
```shell
docker run -p 8080:8080 sbapi:latest
```

### Run the docker-compose file
```shell
docker-compose up --build -d
```

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)

### Additional Links
These additional references should also help you:

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Initializr](https://start.spring.io/)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html)


