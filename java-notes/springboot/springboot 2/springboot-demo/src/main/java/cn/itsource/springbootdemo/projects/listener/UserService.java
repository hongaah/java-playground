package cn.itsource.springbootdemo.projects.listener;

import cn.itsource.springbootdemo.projects.swagger.User;
import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service("ListenerUserService")
public class UserService {

    @Resource
    private ApplicationContext applicationContext;

    /**
     * 获取用户信息
     */
    public User getUser() {
        // 实际中会根据具体的业务场景，从数据库中查询对应的信息
        return new User(1L, "测试", "123456");
    }

    /**
     * 发布事件
     */
    public User publishEvent() {
        // 获取用户信息
        User user = getUser();
        // 发布事件
        MyEvent event = new MyEvent(this, user);
        applicationContext.publishEvent(event);
        return user;
    }
}
