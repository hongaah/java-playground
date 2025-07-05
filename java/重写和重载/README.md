重写（overriding）是指子类对父类的允许访问的方法进行重新编写，返回值和形参都不能改变。
重载（overloading）是指在一个类里面，定义多个同名的方法，但是他们的参数列表不同，根据参数个数不同或参数类型不同而区分开来，使用的时候可以根据参数的不同调用不同的方法。

## 重写和重载的区别主要体现在以下几点：

- 重写是指子类对父类允许访问的方法进行重新编写，重载是在一个类中定义了多个同名的方法。
- 重写是子类覆盖父类方法，重载是在一个类中多次定义同一个方法。
- 重写是父类与子类之间的一种关系，重载是一个类中多个方法之间的关系。
- 重写是面向对象的一种多态性，重载是同一个类中多态性的体现。

重写:

```java
class Vehicle {
  public void run(){
    System.out.println("车在行驶");
  }
}

class Car extends Vehicle {
  @Override
  public void run(){
    System.out.println("汽车在行驶");
  }
}
```

重载:

```java
class Vehicle {
  public void run(){
    System.out.println("车在行驶");
  }
  public void run(String name){
    System.out.println(name + "在行驶");
  }
}

// Vehicle类是父类，Car类是子类，重写时，Car类重写了Vehicle类的run()方法，而重载时，Car类在自己的类中定义了多个run()方法，从而实现了重载。
class Car extends Vehicle {
  @Override
  public void run(){
    System.out.println("汽车在行驶");
  }
  public void run(String name,int speed){
    System.out.println(name + "在以" + speed + "的速度行驶");
  }
}
```

## 重写体现了 Java 代码的什么特性？

重写体现了 Java 代码的多态特性，也就是父类中定义的方法可以被子类重写，从而实现不同的行为。例如，在一个父类中定义了一个方法，在子类中可以重写这个方法，实现不同的行为，而不需要改变父类。
