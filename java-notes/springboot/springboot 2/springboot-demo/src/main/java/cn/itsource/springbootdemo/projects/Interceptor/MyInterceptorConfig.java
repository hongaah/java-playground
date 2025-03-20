package cn.itsource.springbootdemo.projects.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/interceptor/**");
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/interceptor/**");
        super.addInterceptors(registry);
    }

    /**
     * 用来指定静态资源不被拦截，否则继承 WebMvcConfigurationSupport 这种方式会导致静态资源无法直接访问
     * 但是，还有更方便的方式来配置。见 MyInterceptor2Config.java
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 确保任何对静态资源（如图片、CSS 文件或 JavaScript 文件）的请求都将从类路径下的 static 目录中获取，而这些资源不会被应用程序的拦截器拦截。
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
