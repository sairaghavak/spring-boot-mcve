## Spring Boot Actuator

- The literal meaning of actuator is a component of a machine that receives a signal and responds by converting the signal's energy into mechanical motion
- Supports buit-in (or custom) endpoints that let you monitor and manage your application, such as application health, metrics, sessions etc
- Spring boot actutator lets you monitor and interact, or control your application
- Provides a lot of automatically built-in features like application health status, JVM memory consumption etc.
- And, all the feautures are exposed through various rest endpoints
- To be remotely accessibly the endpoint also has to be exposed via JMX or HTTP
- All the endpoints suffixed with actuator. Example: /actuator/health
- enabling != exposing endppoint
- Enabling
  - Controls creation of beans in application context
  - Almost all endpoints are enabled by default
  - Efficiency purposes
- Exposing
  - Controls consumption
  - Almost all endpoints are not exposed via HTTP by default
  - Security purposes
- We can make a bean enabled but not exposed, and also a bean exposed but not enabled  
- Spring boot has @EndPoint annotation to create and register a new bean
- We can annoate methods with @ReadOperation, @WriteOperation, @DeleteOperation


### Creating a custom actuator endpoint
- 

### Securing endpoints
- Endpoint security is automatically configured if Spring security is on classpath
  - Adds HTTP basic authentication to all endpoints except
    - health
    - info


### 1.x vs 2.x

- Conceptually both are same, but they differ in implementation


### Spring boot Actuator 1.x
- Spring MVC
- Extension-based
- Hierarchical metrics
- Custom metrics collector
- Less secure by default

### Spring boot Actuator 2.x
- Spring MVC, JAX-RS, and Webflux
- Annotation-driven
- Hierarchical & Dimensional metrics
- MicroMeter-based metrics collection
- More secure by default


### Most common Endpoints and how they're used
- Health endpoint: most used endpoint
  - The results are an aggregation of several health checks
  - Some health checks (indicators) are auto-configured by default
- Metrics endpoint: memory analysis 
- Loggers endpoint: Turn on debug on the fly