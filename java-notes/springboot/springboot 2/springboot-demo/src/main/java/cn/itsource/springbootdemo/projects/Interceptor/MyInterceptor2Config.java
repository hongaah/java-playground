package cn.itsource.springbootdemo.projects.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 继承 WebMvcConfigurationSupport 类的方式可以用在前后端分离的项目中，后台不需要访问静态资源（就不需要放开静态资源了）；
 * 实现 WebMvcConfigure 接口的方式可以用在非前后端分离的项目中，因为需要读取一些图片、css、js文件等等。
 */
@Configuration
public class MyInterceptor2Config implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 实现WebMvcConfigurer不会导致静态资源被拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
