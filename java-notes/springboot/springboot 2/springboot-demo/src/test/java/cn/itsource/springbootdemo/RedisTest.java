package cn.itsource.springbootdemo;

import cn.itsource.springbootdemo.projects.redis.RedisService;
import cn.itsource.springbootdemo.projects.swagger.User;
import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RedisTest {
    private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Resource
    private RedisService redisService;

    @Test
    public void contextLoads() {
        //测试redis的string类型
        redisService.setString("wechat","111111");
        logger.info("我的微信公众号为：{}", redisService.getString("wechat"));

        // 如果是个实体，我们可以使用json工具转成json字符串，
        User user = new User(1L, "CSDN", "123456");
        redisService.setString("userInfo", JSON.toJSONString(user));
        logger.info("用户信息：{}", redisService.getString("userInfo"));
    }

    @Test
    public void testHash(){
        //测试redis的hash类型
        redisService.setHash("user","name","CSDN");
        redisService.setHash("user","password","123456");
        logger.info("用户信息：{}", redisService.getHash("user","name"));
        logger.info("用户密码：{}", redisService.getHash("user","password"));
    }

    @Test
    public void testList(){
        //测试redis的list类型
        redisService.setList("list","CSDN");
        redisService.setList("list","123456");
        List<String> valList = redisService.getList("list", 0, -1);
        for (String value: valList) {
            logger.info("list中有：{}", value);
        }
    }
}