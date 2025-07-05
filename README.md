# spring & spring boot & spring cloud

### 1. **Spring Framework（Spring）**

**Spring** 是一个功能强大的、全面的开源框架，主要用于构建企业级 Java 应用程序。旨在简化 Java 企业应用程序的开发。它并没有预设任何特定的运行环境，需要开发者手动配置很多内容。

#### Spring 提供了很多核心功能，例如：

- **IoC（控制反转）容器：** 提供依赖注入（DI）功能，将对象的创建和管理交给容器，降低了系统的耦合度。
- **AOP（面向切面编程）：** 支持声明式事务、日志记录、性能监控等。
- **事务管理：** 提供一致的事务管理API，支持声明式事务。
- **MVC 框架：** 提供了一个轻量级的 MVC 框架来构建 Web 应用程序。
- **安全：** Spring Security 提供了基于角色的权限管理。
- **数据访问：** 提供了对 JDBC、ORM（如 Hibernate）等的简化支持。


---

### 2. **Spring Boot**

**Spring Boot** 是 Spring Framework 的一个子项目，目的是简化 Spring 应用程序的开发，特别是减少配置和提高开发效率。它通过一系列约定优于配置的理念和内建的功能，使得开发者可以快速启动 Spring 应用程序。

#### Spring Boot 的主要特点：

- **开箱即用：** 提供了大量的默认配置，几乎不需要手动配置 Spring 容器。
- **自动配置：** Spring Boot 会根据你的项目依赖自动配置 Spring 的各个部分（如数据库连接、Web 服务等）。
- **嵌入式服务器：** 支持内嵌的 Tomcat、Jetty 或 Undertow 等 Web 服务器，使得开发者不需要单独配置和部署外部的 Web 服务器。
- **简化的项目结构：** 提供了默认的项目结构，使得开发者不必担心复杂的项目配置。
- **微服务支持：** 通过 Spring Boot 让微服务的开发变得更加简单。

---

### 3. **Spring Cloud**

**Spring Cloud** 是一个专为分布式系统和微服务架构设计的工具集合，它基于 Spring Boot 构建，提供了大量的解决方案，帮助开发者构建、部署和管理微服务。

#### Spring Cloud 提供的核心功能包括：

- **服务发现与注册：** 通过 Netflix Eureka 或 Consul 等服务注册与发现组件，微服务可以动态地注册到服务注册中心，其他服务可以通过服务名进行发现。
- **负载均衡：** 提供客户端负载均衡功能（例如 Ribbon）来平衡请求流量。
- **配置管理：** 使用 Spring Cloud Config 来集中管理不同环境下的配置。
- **断路器：** 使用 Netflix Hystrix 来提供服务容错功能，在微服务出现故障时，保证系统的稳定性。
- **API 网关：** 使用 Spring Cloud Gateway 或 Netflix Zuul 来实现请求的路由、负载均衡、权限管理等功能。
- **分布式跟踪与监控：** 整合了 Spring Boot Actuator 和 Zipkin 等工具，提供分布式系统的监控和日志管理。
- **消息总线：** 使用 Spring Cloud Bus 来实现微服务之间的消息传递。
