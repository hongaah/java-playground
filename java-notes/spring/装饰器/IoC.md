
@Component：相当于定义了一个 Bean，它有一个可选的名称，默认是 mailService，即小写开头的类名。对于Spring容器来说，当我们把一个 Bean 标记为 @Component 后，它就会自动为我们创建一个单例（Singleton），即容器初始化时创建Bean，容器关闭前销毁Bean。在容器运行期间，我们调用 getBean(Class) 获取到的Bean总是同一个实例。

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // @Scope("prototype")：每次调用getBean(Class)，容器都返回一个新的实例，这种 Bean 称为Prototype（原型），它的生命周期显然和 Singleton 不同。声明一个 Prototype 的 Bean 时，需要添加一个额外的 @Scope 注解。

@Autowired：就相当于把指定类型的 Bean 注入到指定的字段中。和 XML 配置相比，@Autowired 大幅简化了注入，因为它不但可以写在 set() 方法上，还可以直接写在字段上，甚至可以写在构造方法中。我们一般把@Autowired 写在字段上，通常使用package权限的字段，便于测试。如果 @Autowired 应用到 List、Map、Set 等集合类型，Spring 会自动把所有匹配的 Bean 注入到这个集合中。
@Autowired(required = false)： 当我们标记了一个 @Autowired 后，Spring 如果没有找到对应类型的 Bean，它会抛出 NoSuchBeanDefinitionException 异常。表示这个 Bean 是可选的，如果找不到，就忽略。


@Configuration：表示它是一个配置类。SpringBoot推荐给容器中添加组件的方式，推荐使用全注解的方式 @Configuration

```java
/**
 * @Configuration：指明当前类是一个配置类，就是来替代之前的Spring配置文件
 * 
 * 在配置文件中用<bean><bean/>标签添加组件。在配置类中使用@Bean注解
 */
@Configuration
public class MyAppConfig {
    // 将方法的返回值添加到容器中;容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService(){
        System.out.println("配置类@Bean给容器中添加组件了");
        return new HelloService();
    }
}
```

@Bean：如果一个 Bean 不在我们自己的 package 管理之内，我们可以自己在 @Configuration 类中编写一个 Java 方法创建并返回它，例如 ZoneId。Spring 对标记为 @Bean 的方法只调用一次，因此返回的 Bean 仍然是单例。

```java
@Configuration
@ComponentScan
public class AppConfig {
    // 创建一个Bean:
    @Bean
    ZoneId createZoneId() {
        return ZoneId.of("Z");
    }
}
```

@Bean("name")：指定别名，也可以用@Bean+@Qualifier("name")指定别名。


@Order：Spring 是通过扫描 classpath 获取到所有的 Bean，而 List 是有序的，要指定 List 中 Bean 的顺序，可以加上 @Order 注解。


@Primary：指定为主要 Bean。在注入时，如果没有指出Bean的名字，Spring会注入标记有@Primary的Bean。这种方式也很常用。例如，对于主从两个数据源，通常将主数据源定义为@Primary

@ComponentScan：它告诉容器，自动搜索当前类所在的包以及子包，把所有标注为 @Component 的 Bean 自动创建出来，并根据 @Autowired 进行装配。
@ComponentScan({ "com.example.demo" })：扫描指定包下的所有类，并自动注册为 Bean。


@PostConstruct：Spring 容器会对 Bean 调用标记有 @PostConstruct 的 init() 方法进行初始化。


@PreDestroy：一个 Bean 在注入必要的依赖后，需要进行初始化（监听消息等）。在容器关闭时，有时候还需要清理资源（关闭连接池等）。销毁时，容器会首先调用标记有 @PreDestroy 的 shutdown() 方法。

