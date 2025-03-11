package cn.itsource.springboothello01.controller;

import cn.itsource.springboothello01.MyPerson;
import cn.itsource.springboothello01.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/json")
public class JsonController {

    @Autowired
    MyPerson myPerson;

    // 返回配置文件设置的值
    @RequestMapping("/01")
    public String json01() {
        return myPerson.getName();
    }

    // 返回对象
    @RequestMapping("/02")
    public Employee json02() {
        return new Employee(1L,"小春风");
    }

    // 返回集合
    @RequestMapping("/03")
    public List<Employee> json03() {
        return Arrays.asList(
                new Employee(1L,"令狐兄"),
                new Employee(2L,"不群兄"),
                new Employee(3L,"我行兄")
        );
    }

    // 返回map
    @RequestMapping("/04")
    public Map<String, Object> json04() {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "小飞侠");
            map.put("age", 24);
            map.put("sex", false);
            return map;
        } catch (Exception e) {
            // 日志记录异常信息
            e.printStackTrace();
            return  new HashMap<>();
        }
    }
}

