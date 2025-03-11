package cn.itsource.springboothello01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@Import(SpringbootHello01Application.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes=MyPerson.class)
public class MyPersonTest {
    @Autowired
    private MyPerson myPerson;

    @Test
    public void test01() {
        System.out.println("MyPersonTest：" + myPerson.getName());
    }
}
