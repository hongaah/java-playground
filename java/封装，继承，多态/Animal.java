public abstract class Animal{
  public abstract void say();
}


public class Cat extends Animal{
  public void say(){
      System.out.println("Meow!");
  }
}

public class Dog extends Animal{
  public void say(){
      System.out.println("Woof!");
  }
}

// 多态
// Animal是一个抽象类，它定义了一个say()方法，Cat和Dog都继承自Animal，它们都实现了say()方法，Cat类中say()方法打印出Meow!，Dog类中say()方法打印出Woof!。然后在Test类中实例化了一个Cat对象和一个Dog对象，并调用了它们的say()方法，这就是多态，一个对象可以具有多种不同的形态。
public class Test{
  public static void main(String[] args){
      Animal animal1 = new Cat();
      Animal animal2 = new Dog();
      animal1.say();
      animal2.say();
  }
}
