# 装配 Bean

让容器来为我们创建并装配 Bean 能获得很大的好处，需要编写一个特定的 application.xml 配置文件，告诉 Spring 的 IoC 容器应该如何创建并组装 Bean。

```xml :application.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="userService" class="com.itranswarp.learnjava.service.UserService">
        <property name="mailService" ref="mailService" />
    </bean>

    <bean id="mailService" class="com.itranswarp.learnjava.service.MailService" />
</beans>

<!-- 如果注入的不是Bean，而是boolean、int、String这样的数据类型，则通过value注入，例如，创建一个HikariDataSource -->
<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource">
    <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/test" />
    <property name="username" value="root" />
    <property name="password" value="password" />
    <property name="maximumPoolSize" value="10" />
    <property name="autoCommit" value="true" />
</bean>
```

- 每个<bean ...>都有一个id标识，相当于Bean的唯一ID；
- 在userServiceBean中，通过<property name="..." ref="..." />注入了另一个Bean；
- Bean的顺序不重要，Spring根据依赖关系会自动正确初始化。

## ApplicationContext

Spring的IoC容器接口是ApplicationContext，并提供了多种实现类；通过XML配置文件创建IoC容器时，使用ClassPathXmlApplicationContext；持有IoC容器后，通过getBean()方法获取Bean的引用。

```java
public class Main {
    public static void main(String[] args) {
        // 创建一个 Spring 的IoC容器实例，然后加载配置文件，让Spring容器为我们创建并装配好配置文件中指定的所有Bean
        // Spring 容器就是 ApplicationContext，它是一个接口，有很多实现类，这里我们选择ClassPathXmlApplicationContext，表示它会自动从 classpath 中查找指定的 XML 配置文件。
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        // 从 Spring 容器中“取出”装配好的Bean然后使用它
        UserService userService = context.getBean(UserService.class);
        User user = userService.login("bob@example.com", "password");
        System.out.println(user.getName());
    }
}
```

