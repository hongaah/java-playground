// 类的定义更多是一个抽象化的概念，而对象基于类的特征所具体化的个体。例如我们可以定义一个animal（动物）类，animal具有名字属性name，那么猫，狗，羊，猪这些个体就是名字属性name值不同的动物对象。

public class Student {
  String name;
  int age;
  String gender;
  
  void study() {
      System.out.println("Student " + name + " is studying.");
  }
  void play() {
      System.out.println("Student " + name + " is playing.");
  }
}

// 在Java体系里面，如果想要执行一个函数，必须要从main开始开始着手。
public class CounterUtil {

  public int count = 0;

  // 构造函数的修饰符可以是 public、protected、private 等，构造函数名必须与类名完全一致，参数列表是可选的，构造函数体是可选的，构造函数不会返回任何类型的值。
  public CounterUtil(int count) {
    this.count = count;
  }

  public int getMaxNumber(int a, int b) {
    if (a > b) {
      return a;
    }
    return b;
  }

  // main 函数是每个 Java 程序的入口点，是 Java 程序执行的第一个函数。它由一个具有特定名称（main）的静态方法组成，它接受一个可选的 String 数组作为参数，并且没有返回值。
  public static void main(String[] args) {
    //通过 new 关键字来创建一个新的对象 counterUtil
    CounterUtil counterUtil = new CounterUtil();

    //使用 counterUtil 对象的 getMaxNumber 方法
    int c = counterUtil.getMaxNumber(1, 2);
    System.out.println(c);
  }
}

// 继承
class littleCounterUtil extends CounterUtil {
  public log(int count) {
    super(count);
  }
}

// 接口 定义了一组方法，但没有实现任何一个，它只是用来被实现的。接口实现了多态，可以让类型有不同的行为。
public interface Counter {
  public void count1();
  public void count2();
}

// 任何实现 Counter 接口的类都必须实现这两个方法
public class MyCounter implements Counter {
  public void count1() {
    // 实现count1()
  }
  public void count2() {
   // 实现count2()
  }
}
