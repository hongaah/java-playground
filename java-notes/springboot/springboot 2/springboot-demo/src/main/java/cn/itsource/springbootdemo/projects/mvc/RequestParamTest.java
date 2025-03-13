package cn.itsource.springbootdemo.projects.mvc;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/RequestParamTest", produces = "application/json;charset=UTF-8")
public class RequestParamTest {
    /**
     * @RequestParam 注解: 获取请求参数
     */
    @GetMapping("/get8")
    public String get8(@RequestParam String id) {
        return "GET请求8，id=" + id;
    }
    // 如果请求参数和方法参数名不一致，可以使用 @RequestParam 中的 value 属性来指定对应关系
    // 比如 /get9?idd=1，获取到的参数为 1
    @GetMapping("/get9")
    public String get9(@RequestParam(value = "idd", required = false, defaultValue = "0") String id) {
        return "GET请求9，id=" + id;
    }
    // 除此之外，该注解还可以用于 POST 请求，接收前端表单提交的参数，假如前端通过表单提交 username 和 password 两个参数，那我们可以使用 @RequestParam 来接收，用法和上面一样。
    @PostMapping("/post1")
    public String post1(@RequestParam String username, @RequestParam String password) {
        return "POST请求1，username=" + username + ", password=" + password;
    }
    // 实体接收
    // 除了上面的方式，还可以使用实体类来接收参数，这样就不用一个个参数接收了，直接接收一个实体类即可。
    // 假如前端通过表单提交 username 和 password 两个参数，那我们可以使用实体类来接收，如下：
    @PostMapping("/post2")
    public String post2(User user) {
        return "POST请求2，username=" + user.getUsername() + ", password=" + user.getPassword();
    }
}
