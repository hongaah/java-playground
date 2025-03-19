package cn.itsource.springbootdemo.entity;

import io.swagger.v3.oas.annotations.media.Schema;

public class User {

    @Schema(description = "用户id", hidden = true)
    private int id;

    @Schema(description = "用户名")
    private String name;

    @Schema(description = "用户年龄")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
