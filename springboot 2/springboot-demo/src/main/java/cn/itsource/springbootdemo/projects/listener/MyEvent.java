package cn.itsource.springbootdemo.projects.listener;

import org.springframework.context.ApplicationEvent;
import cn.itsource.springbootdemo.projects.swagger.User;

/**
 * 自定义事件
 */
public class MyEvent extends ApplicationEvent {
    private User user;

    public MyEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}