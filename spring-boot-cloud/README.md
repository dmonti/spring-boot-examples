### [Spring Cloud Configuration Properties](https://cloud.spring.io/spring-cloud-static/Greenwich.RELEASE/multi/multi__appendix_compendium_of_configuration_properties.html)

#### Spring Eureka Server for service discovey
Registrion server for the microservices, starts at:
- http://localhost:8761

#### Spring Eureka Client for microservice registration
A simple microservice with 2 actions:
- http://localhost:9000/hello
- http://localhost:9000/service-instances/spring-service1

#### Spring Cloud Gateway as API Gateway
An API Gateway to the microservice (Eureka Client), can be accessed from:
- http://localhost:8060/spring-service1/hello
- http://localhost:8060/spring-service1/service-instances/spring-service1
