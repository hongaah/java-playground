package com.test.demo;

public  class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public void sayHello() {
      System.out.println("你好，我是" + this.name + ",今年" + this.age + "岁");
    }

    private void test() {
      System.out.println("this is test");
    }

    @Override
    public String toString() {
      return "Person{" +
              "name='" + name + "'" +
              ", age=" + age +
              "}";
    }
}

