package cn.itsource.springbootdemo;

import cn.itsource.springbootdemo.entity.User;
import cn.itsource.springbootdemo.mapper.UserMapper;
import cn.itsource.springbootdemo.mapper.UserXmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisUserTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserXmlMapper userXmlMapper;

    @Test
    public void testUserMap () {
        User user = userMapper.getUserByName("1");

        System.out.print(user);
    }

    @Test
    public void testUserMapXml () {
        User user = userXmlMapper.getUserByName("1");
        System.out.println(user);
        System.out.println("测试通过");
    }

}
