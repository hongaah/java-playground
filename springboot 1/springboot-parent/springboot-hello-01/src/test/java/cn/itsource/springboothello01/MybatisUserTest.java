package cn.itsource.springboothello01;

import cn.itsource.springboothello01.domain.User;
import cn.itsource.springboothello01.mapper.UserMapper;
import cn.itsource.springboothello01.mapper.UserXmlMapper;
import cn.itsource.springboothello01.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest
public class MybatisUserTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserXmlMapper userXmlMapper;

    @Autowired
    private IUserService userService;

    @Test
    public void testUserMap () {
        List<User> list = userMapper.findAll();

        System.out.print(list);
    }

    @Test
    public void testUserMapXml () {
        List<User> list = userXmlMapper.findAll();
        System.out.println(list);
        System.out.println("测试通过");
    }

    @Test
    public void testAddUserMapXml () {
        try {
            // 使用变量存储测试数据，方便后续修改
            String userName = "张三";
            Integer userAge = 23;

            User user = new User();
            user.setName(userName);
            user.setAge(userAge);
            userXmlMapper.save(user);

            List<User> list = userXmlMapper.findAll();

            // 使用断言验证结果
//            assertNotNull("用户列表不应为空", list);
//            assertFalse("用户列表不应为空", list.isEmpty());
//            assertEquals("用户名称应匹配", userName, list.get(0).getName());
//            assertEquals("用户密码应匹配", userPassword, list.get(0).getPassword());

            System.out.println("用户：" + list);
        } catch (Exception e) {
            // 捕获异常并输出错误信息
            fail("测试失败，原因：" + e);
        }
    }

    @Test
    public void testIUserService(){
        User user = new User();
        user.setName("李四");
        user.setAge(24);
        userService.save(user);
        userService.findAll().forEach(item -> System.out.println(item));
    }
}
