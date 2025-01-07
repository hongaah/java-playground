内部类和外部类是Java中的一种结构，它允许一个类（外部类）定义另一个类（内部类），内部类可以访问外部类的成员变量和方法，而外部类也可以访问内部类的成员变量和方法。 

内部类主要用于： 
1. 解决多重继承的问题，提供更多的灵活性
2. 提高封装性，可以把不需要外部类使用的内部类隐藏起来
3. 能够访问外部类的所有成员，包括私有变量和方法

外部类主要用于：
1. 创建内部类
2. 提供一个简单的方式来访问内部类的方法和属性
3. 提供多层次结构，更好地把代码组织起来

```java
// 外部类
public class OuterClass {
  private int x;
  public void outerMethod(){
    System.out.println("This is outer method");
  }

  //内部类
  public class InnerClass {
    public void innerMethod(){
      System.out.println("This is inner method");
      System.out.println("The value of outer class variable x is "+x);
    }
  }
}

// 创建外部类对象，创建内部类对象
OuterClass outerClass = new OuterClass();
OuterClass.InnerClass innerClass = outerClass.new InnerClass();
// 内部类的方法使用必须通过具体内部类的实例去调用
innerClass.innerMethod();
outerClass.outerMethod();
```