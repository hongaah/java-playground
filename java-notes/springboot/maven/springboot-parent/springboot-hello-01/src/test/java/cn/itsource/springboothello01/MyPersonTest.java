package cn.itsource.springboothello01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MyPerson.class)
public class MyPersonTest {
    @Autowired
    private MyPerson myPerson;

    // 不生效
    @Test
    public void test01() {
        System.out.println("MyPersonTest：" + myPerson.toString());
    }
}
