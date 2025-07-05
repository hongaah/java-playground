package cn.itsource.springbootdemo.projects.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/PathVariableTest", produces = "application/json;charset=UTF-8")
public class PathVariableTest {

    /**
     * @PathVariable 注解: 获取路径中的参数，比如 /get3/1，获取到的参数为 1
     */
    // 如果想要 url 中占位符中的 id 值直接赋值到参数 id 中，需要保证 url 中的参数和方法接收参数一致，否则就无法接收。
    @GetMapping("/get4/{id}")
    public String get4(@PathVariable String id) {
        return "GET请求4，id=" + id;
    }
    // 如果不一致的话，其实也可以解决，需要用 @PathVariable 中的 value 属性来指定对应关系。
    @GetMapping("/get5/{idd}")
    public String get5(@PathVariable(value = "idd") String id) {
        return "GET请求5，id=" + id;
    }
    // or
    @GetMapping("/get6/{idd}")
    public String get6(@PathVariable("idd") String id) {
        return "GET请求6，id=" + id;
    }
    // 对于访问的 url，占位符的位置可以在任何位置，不一定非要在最后，比如这样也行：/xxx/{id}/user。
    // 另外，url 也支持多个占位符，方法参数使用同样数量的参数来接收，原理和一个参数是一样的
    @GetMapping("/get7/{idd}/{name}")
    public String testPathVariable(@PathVariable(value = "idd") Integer id, @PathVariable String name) {
        System.out.println("获取到的id为：" + id);
        System.out.println("获取到的name为：" + name);
        return "success";
    }

}
