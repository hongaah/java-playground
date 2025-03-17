# [EEROR] How to use both @RestControllerAdvice and Swagger UI in Spring boot

目前同时配置了全局错误处理和 swagger 的配置，会导致 swagger-ui.html 页面无法正常显示，报错 jakarta.servlet.ServletException: Handler dispatch failed: java.lang.NoSuchMethodError: 'void org.springframework.web.method
以及 Fetch error response status is 500 v3/api-docs

```java
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();

        logger.error("An error occurred: " + requestURI, e);
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        // new JsonResult("500", "An error occurred: " + e.getMessage());
    }
}
```

解决方法：
```application.properties
springdoc.override-with-generic-response=false
```

相同问题及解决方案：
[How to use both @RestControllerAdvice and Swagger UI in Spring boot](https://stackoverflow.com/questions/79274106/how-to-use-both-restcontrolleradvice-and-swagger-ui-in-spring-boot)