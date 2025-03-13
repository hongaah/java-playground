package cn.itsource.springbootdemo.projects.mvc;

import cn.itsource.springbootdemo.projects.mvc.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/RequestBodyTest", produces = "application/json;charset=UTF-8")
public class RequestBodyTest {
    /**
     * @RequestBody 注解: 获取请求体中的参数
     *
     * @RequestBody 注解用于 POST 请求上，接收 json 实体参数。它和 @RequestParam 表单提交有点类似，只不过参数的格式不同，一个是 json 实体，一个是表单提交。在实际项目中根据具体场景和需要使用对应的注解即可。
     */
    // @RequestBody 注解用于接收前端传来的实体，接收参数也是对应的实体，比如前端通过 json 提交传来两个参数 username 和 password，此时我们需要在后端封装一个实体来接收。在传递的参数比较多的情况下，使用 @RequestBody 接收会非常方便。
    @PostMapping("/user")
    public String testRequestBody(@RequestBody User user) {
        System.out.println("获取到的username为：" + user.getUsername());
        System.out.println("获取到的password为：" + user.getPassword());
        return "success";
    }

}
