# Spring Boot, MySQL, JPA, Hibernate Rest nagp-user-service
## Requirements

1. Java - 1.8.x
2. Maven - 3.x.x
3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/callicoder/spring-boot-mysql-rest-api-tutorial.git
cd nagp-user-service
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
java -jar target/nagp-user-service-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8081>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET     users
    
    POST    users
    
    GET     users/{userId}
    
    PUT     users/{userId}
    
    DELETE  users/{userId}

You can test them using postman or any other rest client.
