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

