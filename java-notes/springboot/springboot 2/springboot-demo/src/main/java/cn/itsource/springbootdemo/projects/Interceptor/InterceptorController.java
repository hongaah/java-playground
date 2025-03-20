package cn.itsource.springbootdemo.projects.Interceptor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interceptor")
public class InterceptorController {

    @RequestMapping("/test")
    public String test() {
        return "hello";
    }
}