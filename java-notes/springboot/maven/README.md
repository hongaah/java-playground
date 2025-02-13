# SpringBoot

SpringBoot是使用 maven (注:也可以使用Gradle) 的方式对 Spring 应用开发进行进一步的封装和简化。

- Gradle
- Maven

### initializr

- [spring initializr](https://start.spring.io/) 选择功能后下载模板
- idea 中直接创建 springboot 项目

可选 web 依赖

### pom.xml

```xml :pom.xml 父模块
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <!--组id-->
    <groupId>cn.itsource</groupId>
    <!--模块名称-->
    <artifactId>springboot-parent</artifactId>
    <!--
        packaging
            jar === 当前项目打成jar包
            war === 当前项目打成war包
            pom === 当前项目不写java代码,权代表用于管理jar包
            maven-plugin === 当前项目用于开发插件使用(暂时不用管)
    -->
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>

    <!--父项目中管理的所有子项目模块-->
    <modules>
        <!--管理的子项目模块,注意名称和子模块名称保持一致-->
        <module>springboot-hello-01</module>
    </modules>


</project>

```

```xml :pom.xml 子模块
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <!--
        当前子模块的pom.xml中没有声音自己的版本与主id
        通过parent 引入父模块中的内容(这里是继承关系)
    -->
    <parent>
        <artifactId>springboot-parent</artifactId>
        <groupId>cn.itsource</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <!--子模块的名称-->
    <artifactId>springboot-hello-01</artifactId>
</project>

```

### 概念

继承 springboot 的父依赖：
- springboot为咱们准备好了相关依赖jar包(下面代码直接拷备使用即可)
- pom.xml是单继承的结构，所以我们在父pom.xml中继承父依赖
- 父依赖中已经声明了很多现在可用的jar包(大家可看源码分析)
- dependencyManagement：只声明 不引用


引入 spring-boot-starter-web：
- 在引入后就会导入spring运行web项目的所有jar包(如spring,日志,mvc包等等)
- springboot有组合包的概念,专门用于简化maven的导包
- springboot提供包的格式: spring-boot-starter-xxx


一个主方法就启动了tomcat：
spring-boot-starter-web内嵌了一个tomcat插件


为什么主方法运行后，应用程序就启动了：
- 初始化运行程序中的所有bean对象(只有扫描它所有的包及其子包的java对象)
- 自动装配springmvc的相关代码与配置(有默认的配置,我们以后可以修改)
- 初始化spring容器
- 把当前应用打成一个jar包放到tomcat中运行

### SpringBoot 三种运行方式

1. 直接运行

2. pom 添加插件运行：
```xml :pom.xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```
maven: springboot-hello-01 插件 spring-boot spring-boot:run

3. 打包运行：
maven: springboot-hello-01 生存期 package
java -jar .\springboot-hello-01\target\springboot-hello-01-0.0.1-SNAPSHOT.jar 


### SpringBoot 配置文件

默认配置文件会在 resources 中，配置文件有两种(我们任选一种即可)
- application.properties
- application.yml

```yml :application.yml
server:
  port: 8088
  servlet:
    path: /haha
```

字符串：
字符串不需要加引号
双引号不会对串中转义字符进行转义
  name: "zhangsan \n lisi"：输出；zhangsan 换行 lisi
单引号转义特殊字符
  name: "zhangsan \n lisi"：输出；zhangsan \n lisi

### 多环境支持方案

#### 多文档块模式

- 使用三个框(---)来区分
- 可调用不同的方式

```yml :application.yml
# 确定哪一个模块为活动模块
spring:
  profiles:
    active: pro

---
#开发模块
server:
  port: 8088
spring:
  config:
    activate:
      on-profile: dev

---
#测试模块
server:
  port: 8089
spring:
  config:
    activate:
      on-profile: test

---
#在线模块
server:
  port: 8099
spring:
  config:
    activate:
      on-profile: pro
```

#### 多 profile 文件模式

1. 创建多个配置文件

application.yml
application-dev.yml
application-test.yml
application-pro.yml

### SpringBoot 测试功能

```java :MyBeanTest.java
@RunWith(SpringRunner.class)
// 代表这是一个SpringBoot的测试
// classes 对应的类必需是经过 SpringBootApplication 修饰的类
@SpringBootTest(classes=MyBean.class)
public class MyBeanTest {
    @Autowired
    private MyBean myBean;

    @Test
    public void test01() {
        System.out.println("MyBeanTest：" + myBean);
    }
}

// 创建一个bean
@Component
public class MyBean {
}
```

### 模板引擎

#### Thymeleaf

- Thymeleaf 是一个模板技术
  - 其它的模板技术: freemarker,velocity,jsp 等
  - jsp 现在用得很少,因为它必需依赖 servlet 容器才能运行,并且编译的效率低下
- springboot 推荐使用 Thymeleaf

配置的步骤：

1. 在 `application.yml` 文件中配置 Thymeleaf 模板路径和后缀。
    ```yaml
    spring:
      thymeleaf:
        prefix: classpath:/templates/
        suffix: .html
    ```

2. 在 `src/main/resources/templates/` 目录下创建 `index.html` 文件，并在其中添加以下内容：
    ```html
    <!DOCTYPE html>
    <html xmlns:th="http://www.thymeleaf.org">
    <head>
        <title>Index Page</title>
    </head>
    <body>
        <p th:text="${msg}">This is a placeholder text.</p>
    </body>
    </html>
    ```

3. 在 `pom.xml` 文件中添加了 Thymeleaf 依赖：
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    ```

4. 调用。注意类不能使用 @RestController 注解，这意味着所有方法默认返回 JSON 或字符串，而不是视图。要返回视图模板，需要使用 @Controller 注解。
    ```java
    @Controller
    public class HelloController {

        @GetMapping("/")
        public String hello() {
            return "Hello, World!";
        }

        @RequestMapping("/hello")
        public String index(Model model) {
            model.addAttribute("msg", "hello,Springboot");
            return "index";
        }
    }
    ```

完成以上步骤后，访问 `/hello` URL 应该会渲染 `index.html` 页面，并显示 `msg` 属性的值。

### 框架集成

#### 集成 redis

集成 redis 的步骤：🌰：java-notes\springboot\maven\springboot-parent\springboot-hello-01

1. 在 `pom.xml` 文件中添加以下依赖：
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
    ```

2. 在 `application.yml` 文件中配置：
    ```yaml
    spring:
      data:
        redis:
          host: 127.0.0.1
          port: 6379
    ```

3. 配置 RedisTemplate 使用字符串序列化器，避免 Redis 中显示乱码
      ```java
      package cn.itsource.springboothello01.config;

      @Configuration
      public class RedisConfig {
          @Bean
          public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
              RedisTemplate<String, String> template = new RedisTemplate<>();
              template.setConnectionFactory(connectionFactory);
              // 设置键的序列化器
              template.setKeySerializer(new StringRedisSerializer());
              // 设置值的序列化器
              template.setValueSerializer(new StringRedisSerializer());
              return template;
          }
      }
    ```

4. 引用 RedisTemplate：
    在需要使用 RedisTemplate 的地方，可以通过 @Autowired 注解将其注入到类中。
    @Autowired：自动注入 RedisTemplate 实例，Spring 会从容器中找到 RedisTemplate Bean 并注入。

    例如，在 RedisController 中引用 RedisTemplate：
    ```java
    @RestController
    @RequestMapping("/redis")
    public class RedisController {

        @Autowired
        private RedisTemplate<String, String> redisTemplate;

        @RequestMapping("/set")
        public String testSet() {
            redisTemplate.opsForValue().set("name", "李四");
            return "set done";
        }

        @RequestMapping("/get")
        public String testGet() {
            String name = redisTemplate.opsForValue().get("name");
            System.out.println("/REDIS GET " + name);
            return "get done";
        }
    }
    ```

5. 验证配置是否生效
    启动 Spring Boot 应用后，可以通过以下方式验证配置是否生效：
    调用 /redis/set 接口，将数据存储到 Redis。
    调用 /redis/get 接口，从 Redis 中获取数据。
    检查 Redis 中存储的键和值是否为字符串格式，且无乱码。

#### 整合 MyBatis 和 Mysql

- 引入 mybatis 起步依赖, 添加 mysql 驱动
- 编写 DataSource 和 MyBatis 相关配置
- 定义表和实体类
- 编写 dao 和 mapper 文件/纯注解开发
- 测试

集成步骤：🌰：java-notes\springboot\maven\springboot-parent\springboot-hello-01

1. 在 `pom.xml` 文件中添加以下依赖：
    ```xml
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
        <version>8.0.32</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>3.0.3</version>
    </dependency>
    ```

2. 在 `application.yml` 文件中配置：
    ```yaml
    spring:  datasource:
      driver-class-name: com.mysql.cj.jdbc.Driver
      # serverTimezone=UTC 配置时区的，时区对应不上会报错
      # 本地的可以用///表示
      url: jdbc:mysql:///jdbc?serverTimezone=UTC
      username: root
      password: hazel

    mybatis:
      mapper-locations: classpath:mybatis/mapper/*Mapper.xml # mapper配置文件的路径，这里匹配所有以Mapper.xml结尾的文件
      type-aliases-package: cn.itsource.springboothello01.domain # domain的全路径
      # config-location: # 指定mybatis的核心配置文件
    ```

3. 新建一个 User 类，添加用户名和密码的属性，在文件中右键，选择【Gererate】， 选择【Getter and Getter】，勾选上对应的属性，快速创建 getter、setter、toString 方法。
      ```java
      package cn.itsource.springboothello01.domain;

      public class User {
          private int id;
          private String name;
          private String password;
      }
    ```

4. 方法一：mapper 方式,调用数据库，mapper 的作用是作为单独的一层，写一些数据库相关操作的映射

    ```java
    package cn.itsource.springboothello01.mapper;

    @Mapper
    @Repository
    public interface UserMapper {

        @Select("select * from user")
        public List<User> findAll();
    }

    ```

5. 方法二：mapperXml 方式,调用数据库
    ```java
    package cn.itsource.springboothello01.mapper;

    @Mapper
    @Repository
    public interface UserXmlMapper {
        public List<User> findAll();
    }
    ```

然后我们写一个xml文件，里边有我们需要的sql语句，以及对应方法的映射，我们通常把这种配置文件放在resource文件夹下：

```xml :src/main/resources/mybatis/mapper/UserMapper.xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace 是写的查询数据库接口的全路径，表示当前xml和那个文件的映射，id 就是 对应方法名，resultType 是别名 -->
<mapper namespace="cn.itsource.springboothello01.mapper.UserXmlMapper">
    <select id="findAll" resultType="user">
        select * from user
    </select>
</mapper>
```

5. 测试配置是否生效

```java
package cn.itsource.springboothello01;

import cn.itsource.springboothello01.domain.User;
import cn.itsource.springboothello01.mapper.UserMapper;
import cn.itsource.springboothello01.mapper.UserXmlMapper;

@SpringBootTest
public class MybatisUserTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserXmlMapper userXmlMapper;

    @Test
    public void testUserMap () {
        List<User> list = userMapper.findAll();

        System.out.print(list);
    }

    @Test
    public void testUserMapXml () {
        List<User> list = userXmlMapper.findAll();
        System.out.println(list);
        System.out.println("测试通过");
    }
}
```

