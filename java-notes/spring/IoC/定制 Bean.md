# 定制 Bean

Spring 默认使用 Singleton 创建 Bean，也可指定 Scope 为 Prototype；

可将相同类型的 Bean 注入 List 或数组；

可用 @Autowired(required=false) 允许可选注入；

可用带 @Bean 标注的方法创建 Bean；

可使用 @PostConstruct 和 @PreDestroy 对 Bean 进行初始化和清理；

相同类型的 Bean 只能有一个指定为 @Primary，其他必须用 @Qualifier("beanName") 指定别名；

注入时，可通过别名 @Qualifier("beanName") 指定某个Bean；

可以定义 FactoryBean 来使用工厂模式创建Bean。
