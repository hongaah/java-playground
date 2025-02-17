package cn.itsource.springboothello01;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "person") // 表示 yaml 中的 person 配置和类中的属性一一对应
public class MyPerson {
    private String name;
    private Integer age;
    private Boolean boss;

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

}
