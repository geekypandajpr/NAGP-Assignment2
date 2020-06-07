# Spring Boot, MySQL, JPA, Hibernate Rest nagp-aggregate-service
## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/geekypandajpr/NAGP-Assignment2.git
cd nagp-aggregate-service
```

**2. Create Mysql database**
```bash
create database nagp_test
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/nagp-aggregate-service-1.0.0.jar
```
./mvnw package && java -jar target/napg-aggregate-service-0.1.0.jar

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8082>.

## Explore Rest APIs

The app defines following CRUD APIs.
=
    GET     orderdetails/{userId}

You can test them using postman or any other rest client.
