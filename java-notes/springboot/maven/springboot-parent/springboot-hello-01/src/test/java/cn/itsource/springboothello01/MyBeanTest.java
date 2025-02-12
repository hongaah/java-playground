package cn.itsource.springboothello01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
// 代表这是一个SpringBoot的测试
// classes对应的类必需是经过SpringBootApplication修饰的类
@SpringBootTest(classes=MyBean.class)
public class MyBeanTest {
    @Autowired
    private MyBean myBean;

    @Test
    public void test01() {
        System.out.println("MyBeanTest：" + myBean);
    }
}
