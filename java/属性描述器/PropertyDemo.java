package com.test.demo;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class PropertyDemo {

  public static void main(String[] args) throws IntrospectionException {
      PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name",Person.class);
      Method readMethod = propertyDescriptor.getReadMethod();
      Method writeMethod = propertyDescriptor.getWriteMethod();
      Class propertyType = propertyDescriptor.getPropertyType();
      System.out.println(propertyType);
      System.out.println(readMethod);
      System.out.println(writeMethod);
  }
}

class Person {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}