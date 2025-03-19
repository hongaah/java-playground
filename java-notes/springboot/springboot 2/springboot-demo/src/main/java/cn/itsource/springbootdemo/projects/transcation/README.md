事务回滚注意事项：
1. @Transactional(rollbackFor = Exception.class)

Spring Boot 默认的事务规则是遇到运行异常（RuntimeException）和程序错误（Error）才会回滚。比如上面我们的例子中抛出的 RuntimeException 就没有问题，但是抛出 SQLException 就无法回滚了。

针对非运行时异常，如果要进行事务回滚的话，可以在 @Transactional 注解中使用 rollbackFor 属性来指定异常，比如 @Transactional(rollbackFor = Exception.class)，这样就没有问题了，所以在实际项目中，一定要指定异常。

2. try...catch

在处理异常时，有两种方式，要么抛出去，让上一层来捕获处理；要么把异常 try catch 掉，在异常出现的地方给处理掉。就因为有这中 try…catch，所以导致异常被 ”吃“ 掉，事务无法回滚。所以遇到这种问题，直接往上抛，给上一层来处理即可。

3. 事务范围

```java
@Service
public class UserServiceImpl implements UserService {
 
    @Resource
    private UserMapper userMapper;
 
    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized void isertUser4(User user) {
        // 实际中的具体业务……
        userMapper.insertUser(user);
    }
}
```

可以看到，因为要考虑并发问题，我在业务层代码的方法上加了个 synchronized 关键字。我举个实际的场景，比如一个数据库中，针对某个用户，只有一条记录，下一个插入动作过来，会先判断该数据库中有没有相同的用户，如果有就不插入，就更新，没有才插入，所以理论上，数据库中永远就一条同一用户信息，不会出现同一数据库中插入了两条相同用户的信息。

但是在压测时，就会出现上面的问题，数据库中确实有两条同一用户的信息，分析其原因，在于事务的范围和锁的范围问题。

从上面方法中可以看到，方法上是加了事务的，那么也就是说，在执行该方法开始时，事务启动，执行完了后，事务关闭。但是 synchronized 没有起作用，其实根本原因是因为事务的范围比锁的范围大。也就是说，在加锁的那部分代码执行完之后，锁释放掉了，但是事务还没结束，此时另一个线程进来了，事务没结束的话，第二个线程进来时，数据库的状态和第一个线程刚进来是一样的。即由于mysql Innodb引擎的默认隔离级别是可重复读（在同一个事务里，SELECT的结果是事务开始时时间点的状态），线程二事务开始的时候，线程一还没提交完成，导致读取的数据还没更新。第二个线程也做了插入动作，导致了脏数据。

这个问题可以避免，第一，把事务去掉即可（不推荐）；第二，在调用该 service 的地方加锁，保证锁的范围比事务的范围大即可。


