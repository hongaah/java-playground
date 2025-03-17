package cn.itsource.springbootdemo.projects.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger配置类
 *
 * visit http://localhost:8001/swagger-ui/index.html
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .openapi("3.0.0")
                .info(new Info()
                        .title("Spring Boot集成Springdoc OpenAPI 3接口总览")
                        .version("1.0")
                        .description("Spring Boot集成Springdoc OpenAPI 3"));

    }
}
