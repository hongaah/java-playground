package cn.itsource.springbootdemo.projects.transcation;

import cn.itsource.springbootdemo.entity.User;
import cn.itsource.springbootdemo.projects.exception.JsonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController("transcationUserController")
@RequestMapping("/transcation")
@Tag(name = "TranscationControllerApi", description = "Swagger接口Tag")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getUserByName")
    @Operation(summary = "事务 - 通过名字查找用户", description = "通过名字查找用户")
    public JsonResult getUserByName(@RequestParam @Schema(description = "用户名") String name) {
        if (name != null) {
            User user = userService.getUserByName(name);
            return JsonResult.success(user);
        } else {
            return JsonResult.error("用户名为空");
        }
    }

    @PostMapping("/insertUser")
    @Operation(summary = "事务 - 添加用户", description = "添加用户")
    public JsonResult insertUser(@RequestBody User user) throws Exception {
        if (user != null) {
            if (userService.getUserByName(user.getName()) != null) {
                return JsonResult.error("用户名已存在");
            }

            userService.insertUser(user);
            return JsonResult.success("添加成功");
        } else {
            return JsonResult.error("用户为空");
        }
    }
}
