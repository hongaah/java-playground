## 在 cmd 用 javac 编译 .java 时报错： "类 HelloWorld 是公共的, 应在名为 HelloWorld.java 的文件中声明"

FIX: 源文件名应与类名一致

## 进程已结束，退出代码为 0

1. 添加 web 依赖

```xml :pom.xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

## 热更新失败

❌ 按以下步骤操作，但是热更新还是失败

1. 添加依赖

```xml :pom.xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

2. 

```properties application.properties
# application.properties
spring.devtools.restart.exclude=static/**,public/**
spring.devtools.restart.enabled=true
```

3. idea 启用了勾选：自动构建项目
4. 清缓存一系列操作后重启

---

以下三种选一个试下

- ✅ 配置 idea: 右键应用 run 编辑 -> 运行/调试配置窗口 修改选项 执行“更新”操作时 -> 更新类和资源（热交换类，如果失败则更新触发器文件（编辑器失焦就重启服务））。

- ✅ 用快捷键 ctrl f9 重新编译

- ✅ 在pom.xml中加上热部署插件

    ```xml :pom.xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
    <scope>true</scope>
    </dependency>
    ```
