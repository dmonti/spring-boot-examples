### [Spring Cloud Configuration Properties](https://cloud.spring.io/spring-cloud-static/Greenwich.RELEASE/multi/multi__appendix_compendium_of_configuration_properties.html)

## Spring Eureka Server for service discovey
Register all microservices, starts at:
- http://localhost:8761

## Spring Eureka Client for microservice registration
A simple microservice with 2 actions:
- http://localhost:9000/hello
- http://localhost:9000/service-instances/spring-service1

## Spring Zuul Client as API Gateway
An API Gateway to the microservice, can be accessed from:
- http://localhost:8762/service1/hello
- http://localhost:8762/service1/service-instances/spring-service1