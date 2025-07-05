package com.test.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassDemo {

  public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

      Class clazz = Class.forName("com.test.demo.Person");
      // 获取类名
      String className = clazz.getName();
      System.out.println(className);
      // 获取父类
      Class superClass = clazz.getSuperclass();
      System.out.println(superClass.getName());
      // 获取声明类
      Class declaringClass = clazz.getDeclaringClass();
      System.out.println(declaringClass);
      // 获取接口
      Class[] interfaces = clazz.getInterfaces();
      System.out.println(interfaces);
      // 获取类的修饰符
      int modifiers = clazz.getModifiers();
      // 获取类的公共属性
      Field[] fields = clazz.getFields();
      for (Field field : fields) {
          System.out.println(field.getName());
      }
      // 获取类的公共方法
      Method[] methods = clazz.getMethods();
      for (Method method : methods) {
        System.out.println(method.getName());
      }
      // 获取类的构造方法
      Constructor[] constructors = clazz.getConstructors();
      for (Constructor constructor : constructors) {
        System.out.println(constructor.getName());
      }
      // 获取类的所有属性（包括私有属性）
      Field[] declaredFields = clazz.getDeclaredFields();
      for (Field declaredField : declaredFields) {
          System.out.println(declaredField);
      }
      // 获取类的所有方法（包括私有方法）
      Method[] declaredMethods = clazz.getDeclaredMethods();
      for (Method declaredMethod : declaredMethods) {
          System.out.println(declaredMethod);
      }
      // 获取类的所有构造方法（包括私有构造方法）
      Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
      for (Constructor declaredConstructor : declaredConstructors) {
          System.out.println(declaredConstructor);
      }
      // 创建实例
      Object obj = clazz.newInstance();
      System.out.println(obj);
  }
}
