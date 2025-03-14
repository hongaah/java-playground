package cn.itsource.springbootdemo.projects.swagger;

import cn.itsource.springbootdemo.projects.json.JsonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import cn.itsource.springbootdemo.projects.swagger.User;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swagger")
@Tag(name = "SwaggerControllerApi", description = "Swagger接口Tag")
public class SwaggerController {

    @PostMapping("/postJson")
    @Operation(summary = "postJson 接口summary", description = "postJson 接口description")
    public String swagger1(@RequestBody User user) {
        return user.toString();
    }

    @GetMapping("/getPath/{username}")
    @Operation(summary = "getPath 接口summary", description = "getPath 接口description")
    public JsonResult<User> swagger2(@PathVariable @Schema(description = "用户名") String username) {
        System.out.println("username:" + username);

        User user = new User(1L, username, "123456");
        return new JsonResult<User>(user);
    }
}
