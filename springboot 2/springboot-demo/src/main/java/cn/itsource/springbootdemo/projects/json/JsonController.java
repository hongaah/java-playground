package cn.itsource.springbootdemo.projects.json;

import cn.itsource.springbootdemo.projects.json.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/json")
public class JsonController {

    // fastjson jackson 转换 null 成功
    @RequestMapping("/user")
    public User getUser() {
        return new User(1L, null, "123456");
    }

    // fastjson jackson 转换 null 成功
    @RequestMapping("/list")
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1L, null, "123456");
        User user2 = new User(2L, "测试2", "123456");
        userList.add(user1);
        userList.add(user2);
        return userList;
    }

    // jackson 转换 null 成功，fastjson 不成功
    // map 中不管是什么数据类型，都可以转成相应的 json 格式
    @RequestMapping("/map")
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>(3);
        User user = new User(1L, "测试", "123456");
        map.put("作者信息", user);
        map.put("CSDN地址", "http://blog.csdn.net");
        map.put("博客地址", null);
        map.put("测试数量", 1);
        return map;
    }
}
