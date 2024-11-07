# Customer with Addresses

Customer with Addresses (Interview Challenge)

## Table of Contents

1. [Getting Started](#getting-started)
   1. [Prerequisites](#prerequisites)
2. [Technologies](#technologies)
   1. [Prerequisites](#prerequisites)
3. [Project Structure](#project-structure)
   1. [Clean/Hexagonal Architecture](#cleanhexagonal-architecture)
   2. [3-Tier Architecture](#3-tier-architecture)
   3. [Simple Domain Packaging](#simple-domain-packaging)
4. [API First](#api-first)
   1. [OpenAPI / SwaggerUI](#openapi--swaggerui)
      1. [Customization](#customization)
5. [Code Formatting](#code-formatting)

## Getting Started

After cloning the project, you can start the project with the following command:

```bash
docker-compose up -d
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

### Prerequisites

* Java 17+
* Maven 3.6+
* Docker/Docker Compose (you can use Rancher Desktop)
* Git
* SDKMAN! (optional but highly recommended)

## Technologies

* Spring Boot 3.3.x
* Spring Data JPA or MongoDB
* Spring Cloud Streams for Kafka
* Spring Security
* KarateDSL for API Testing


## Project Structure

This project is a blank canvas, you can follow a Traditional 3-Tier Architecture, or a Simple Domain Packaging.


### Traditional 3-Tier Architecture

```
📦 <basePackage>
   📦 web
       └─ RestControllers (spring mvc)
   📦 events
       └─ *EventListeners (spring-cloud-streams)
   📦 domain/model
       └─ (entities and aggregates)
   📦 service
       ├─ dtos/
       └─ ServiceInterface (inbound service interface)
       └─ 📦 implementation
           ├─ mappers/
           └─ ServiceImplementation (inbound service implementation)
   📦 repositories
       ├─ mongodb
       |   └─ CustomRepositoryImpl (spring-data custom implementation)
       └─ jpa
           └─ CustomRepositoryImpl (spring-data custom implementation)
```

### Simple Domain Packaging

Use a simple domain packaging for small projects with just one entity or aggregate, where you plan to have just one service, one repository, and one controller. Also useful for modular monoliths where each module follows a simple domain packaging.

``` 
📦 <basePackage>
   📦 domain/model (entities or aggregate)
   📦 dtos
   📦 mappers
   └─ RestController (spring mvc)
   └─ EventListener (spring-cloud-streams)
   └─ ServiceInterface (inbound service interface)
   └─ ServiceImplementation (inbound service implementation)
   └─ CustomRepositoryImpl (spring-data custom implementation)
```

## API First

### OpenAPI / SwaggerUI

The project uses `openapi-generator-maven-plugin` (see pom.xml) to generate SpringMVC interfaces and DTOs from the `src/main/resources/public/apis/openapi.yml` file.

Generated sources are placed in `target/generated-sources/openapi` which becomes a source folder for the project. To implement the API, you can create a new `@RestController` and implement the generated interface.

#### Customization

You can customize generated code with this properties in `pom.xml` or directly in the plugin `openapi-generator-maven-plugin`: 
```xml
<openApiApiPackage>${basePackage}.adapters.web</openApiApiPackage>
<openApiModelPackage>${basePackage}.adapters.web.model</openApiModelPackage>
```

SwaggerUI is available at http://localhost:8080/swagger-ui/index.html. If you need to add more OpenAPI files, you can customize SwaggerUI in `application.yml`:

```yaml
springdoc.swagger-ui.urls:
   - name: ${projectName}
     url: /apis/openapi.yml
```

URL is relative to 'src/main/resources/public'.

## Code Formating

This project is configured to use Spring Java Format as code formatter. You can apply code formatting from the command line with the following command:

```bash
mvn spring-javaformat:apply
```

You can also configure your IDE for code automatic code formating with the following plugins:

- https://github.com/spring-io/spring-javaformat?tab=readme-ov-file#eclipse
- https://github.com/spring-io/spring-javaformat?tab=readme-ov-file#intellij-idea

Keep a consistent code style from the beginning of the project.


Happy Coding!! 🚀🚀🚀
