public class LambdaDemo {
  public static void main(String[] args) {
      // MyFunctionalInterface myFunctionalInterface = new MyFunctionalInterface() {
      //   @Override
      //   public void doSomething() {
      //       System.out.println("Anonymous Inner Class");
      //   }
      // };

      // 以上代码等价于 lambda 表达式
      MyFunctionalInterface myFunctionalInterface = () -> System.out.println("Lambda Expression");
      myFunctionalInterface.doSomething();
  }
}

@FunctionalInterface
interface MyFunctionalInterface {
    void doSomething();
}
