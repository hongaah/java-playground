
public class Test1 {
  public int a; //可以被任何类访问
  protected int b; //可以被同一个包中的类以及所有子类访问
  private int c; //只能被同一个类中的方法访问
}

public class Test2 {
  public static void main(String args[]) {
      Test1 test = new Test1();
      test.a = 1; //可以访问
      //test.b = 2; //不能访问
      //test.c = 3; //不能访问
  }
}

public class Test extends Test {
  public static void main(String args[]) {
      Test test = new Test();
      test.a = 1; //可以访问
      test.b = 2; //可以访问
      //test.c = 3; //不能访问
  }
}
