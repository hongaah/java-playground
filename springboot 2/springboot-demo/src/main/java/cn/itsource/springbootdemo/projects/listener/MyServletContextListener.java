package cn.itsource.springbootdemo.projects.listener;

import cn.itsource.springbootdemo.projects.swagger.User;
import cn.itsource.springbootdemo.projects.listener.UserService;
import jakarta.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 使用ApplicationListener来初始化一些数据到application域中的监听器
 */
@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // 先获取到application上下文
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        // 获取对应的service
        cn.itsource.springbootdemo.projects.listener.UserService userService = applicationContext.getBean(cn.itsource.springbootdemo.projects.listener.UserService.class);
        User user = userService.getUser();
        // 获取application域对象，将查到的信息放到application域中
        ServletContext application = applicationContext.getBean(ServletContext.class);
        application.setAttribute("user", user);
    }
}
