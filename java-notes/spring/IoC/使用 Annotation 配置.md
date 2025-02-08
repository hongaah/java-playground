# Annotation 注释注解

使用 Annotation 配置 IoC 容器，可以完全不需要 XML，让 Spring 自动扫描 Bean 并组装它们。

@Component 注解就相当于定义了一个 Bean，它有一个可选的名称，默认是 mailService，即小写开头的类名。
@Autowired 就相当于把指定类型的 Bean 注入到指定的字段中。和 XML 配置相比，@Autowired 大幅简化了注入，因为它不但可以写在 set() 方法上，还可以直接写在字段上，甚至可以写在构造方法中。我们一般把@Autowired 写在字段上，通常使用package权限的字段，便于测试。
@Configuration 表示它是一个配置类。
@ComponentScan 它告诉容器，自动搜索当前类所在的包以及子包，把所有标注为 @Component 的 Bean 自动创建出来，并根据 @Autowired 进行装配。

使用Annotation配合自动扫描能大幅简化Spring的配置，我们只需要保证：

- 每个 Bean 被标注为 @Component 并正确使用 @Autowired 注入；
- 配置类被标注为 @Configuration 和 @ComponentScan；
- 所有 Bean 均在指定包以及子包内。

```java
@Component
public class UserService {
    MailService mailService;

    public UserService(@Autowired MailService mailService) {
        this.mailService = mailService;
    }
}

@Configuration
@ComponentScan
public class AppConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = userService.login("bob@example.com", "password");
        System.out.println(user.getName());
    }
}
```



