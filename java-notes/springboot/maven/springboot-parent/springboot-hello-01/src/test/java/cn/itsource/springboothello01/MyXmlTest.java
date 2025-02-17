package cn.itsource.springboothello01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MyXml.class)
public class MyXmlTest {
    @Autowired
    private MyXml myXml;

    @Test
    public void test01() {
        System.out.println("MyXmlTest：" + myXml.getMsg());
    }

    @Test
    public void test02() {
        System.out.println("MyXmlTest：" + myXml.getEnvVar());
    }
}
