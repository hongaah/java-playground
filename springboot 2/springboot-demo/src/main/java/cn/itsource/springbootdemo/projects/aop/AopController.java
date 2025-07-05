package cn.itsource.springbootdemo.projects.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopController {

    private static final Logger log = LoggerFactory.getLogger(AopController.class);

    @GetMapping("/{name}")
    public String testAop(@PathVariable String name) {
        log.info("testAop，name：{}", name);

        return "Hello " + name;
    }
}