package cn.itsource.springboothello01.controller;

import cn.itsource.springboothello01.domain.User;
import cn.itsource.springboothello01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/testMyBatis/user")
public class UserMapContoller {
    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    // GET /save1?name=赵五&age=20
    // Spring 会自动将 name 和 age 参数映射到 User 对象的 name 和 age 属性
    @RequestMapping("/save1")
    public String save(User user) {
        userService.save(user);
        return "保存成功";
    }

    // GET /save2?name=1&age=1
    @RequestMapping("/save2")
    public String save(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);

        userService.save(user);
        return "保存成功";
    }
}
