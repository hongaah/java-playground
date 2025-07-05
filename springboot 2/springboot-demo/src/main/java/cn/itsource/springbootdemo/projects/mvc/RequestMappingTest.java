package cn.itsource.springbootdemo.projects.mvc;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/RequestMappingTest", produces = "application/json;charset=UTF-8")
public class RequestMappingTest {
    /**
     * @RequestMapping 注解
     */
    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    public String get1() {
        return "GET请求1";
    }

    /**
     * @GetMapping、@PostMapping、@PutMapping、@DeleteMapping 注解
     */
    @GetMapping("/get2")
    public String get2() {
        return "GET请求2";
    }

    @PutMapping("/put")
    public String put() {
        return "PUT请求";
    }

    @PostMapping("/post")
    public String post() {
        return "POST请求";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "DELETE请求";
    }
}
