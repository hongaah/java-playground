# YAML 语法

YAML是专门用来配置的语言，有广泛的应用，比如作为脚本语言，序列化，最典型的就是做配置文件

- 大小写敏感
- 数据值前边必须有空格，作为分隔符
- 使用缩进标识层级关系
- 缩进式不允许使用Tab键，只允许使用空格（各个系统Tab对应的空格数目可能不同，导致层次混乱，但是：idea对yaml有良好的支持，使用tab键缩进也能是排版整洁）
- 缩进的空格数目不重要，只要相同层级的原色左对齐即可
- “#” 表示注释，从之歌字符一直到行尾，都会被解析器忽略
- 配置文件优先级： .properties>.yml>yaml

## 数据格式

```yaml
# 字符串 数字 布尔值：不需要加引号
server:
  port: 8088
  servlet:
    path: /haha

# 对象（map）: 键值对的集合
# 一般写法
person:
    name: zhangsan 
# 行内写法
person: {name: zhangsan}

# 数组：子组按次序排列的值
# 一般写法
address:
    - beijing
    - shanghai
# 行内写法
address: [beijing,shanghai]


# 单引号忽略转义字符，输出为一行
msg1: 'hello \n world'
# 双引号识别转义字符，输出为两行
msg2: "hello \n world"


# 参数引用
person:
    speak: ${msg2}

```

## 读取配置内容的三种方式

```java

// 1. @value
@Value("${name}")
private String name

@Value("${person.name}")
private String name2

@Value("${address[1]}")
private String name3

// 2. 环境对象： Environment
@Autowired
private Environment env

System.out.print(env.getProperty("person.name"))

// 3. @ConfigurationProperties
@Component
@ConfigurationProperties(prefix = "person") // 表示 yaml 中的 person 配置和类中的属性一一对应
public class Person {
    private String name;

    public void setName ( String name ) {
        this.name = name
    }

    public String getName () {
        return name
    }
}
```

## Profile

profile 是用来完成不同环境下，配置动态切换功能的多环境支持方案

1. 多profile 文件方式： 提供多个配置文件， 每个代表一种环境，例如：
  application-dev.yml 开发环境
  application-test.yml 测试环境
  application-pro.yml 生产环境

  默认情况下，SpringBoot 会加载主配置文件，即 application.yml。在主文件application.yml通过设置 spring.profiles.active = dev 激活

2. yml多文档方式，写在一个文件即可，使用---分割不同配置

```yaml
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

### profile激活方式

```
1. 配置文件： 在配置文件中配置： spring.profiles.active = dev
2. 虚拟机参数： 在VM options指定： -Dspring.profiles.active = dev
3. 命令行参数： java -jar xxx.jar --spring.profiles.active = dev
```

## 内部加载顺序

Springboot程序启动时，会从以下顺序的优先级加载配置文件

- file:./config/: 当前项目下的/config目录下
- file:./：当前项目的根目录
- classpath:/config/: classpath的/config目录下
- classpath:/ ：classpath的根目录（我们平常在resources下写的配置文件会被打包到这个目录下）

打包不会把 config 目录下的配置打进去

### 运行时自定义参数

```sh
# 通过命令行
java -jar .\java-spring-boot-0.0.1-SNAPSHOT.jar --server.port=8082

# 使用命令指定当前配置
java -jar .\java-spring-boot-0.0.1-SNAPSHOT.jar --spring.config.location=d://application.yaml

# 如果和jar包在同级目录，我们可以使用相对路径
java -jar .\java-spring-boot-0.0.1-SNAPSHOT.jar --spring.config.location=./application.yaml

# 如果配置文件和jar包在同级目录，或者同级目录的config文件，可以不用指定配置文件，他会默认加载这两个路径的配置文件
java -jar .\java-spring-boot-0.0.1-SNAPSHOT.jar
```
