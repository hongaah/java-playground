import java.util.Scanner;

public class IO {
  public static void main(String[] args) {
    // 从键盘输入
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入你的名字：");

    // Scanner类是Java中的一个用于处理输入的工具类，它可以从控制台、文件、字符串等输入源读取数据。Scanner类提供了next()、nextLine()、nextInt()等方法，可以读取不同类型的数据。Scanner类还支持正则表达式，可以根据特定的模式来读取输入。

    // next()方法用于读取一个单词返回的是一个字符串，nextLine()方法用于读取一行，nextInt()方法用于读取一个整数。
    String name = scanner.next();
    int inputNum = scanner.nextInt();

    // Scanner 类支持正则表达式，只会接收字母组成的字符串，其他类型的输入会引起类型匹配异常，从而中止程序的执行。
    String nameReg = scanner.next("[a-zA-Z]+");
    System.out.println("你好1，"+name+"！");
    System.out.println("你好2，"+nameReg+"！");

    if (inputNum > 0 || inputNum <= 0) {
      System.out.println("你输入的数字是："+inputNum);
    }

    // System.out也可以用来输出计算结果
    int a = 10;
    int b = 20;
    int c = a + b;
    System.out.println("a + b = "+c);
  }
}

