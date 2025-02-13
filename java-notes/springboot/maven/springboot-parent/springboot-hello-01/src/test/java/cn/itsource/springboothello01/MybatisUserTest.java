package cn.itsource.springboothello01;

import cn.itsource.springboothello01.domain.User;
import cn.itsource.springboothello01.mapper.UserMapper;
import cn.itsource.springboothello01.mapper.UserXmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisUserTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserXmlMapper userXmlMapper;

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
}
