public class LambdaTypeDemo {
  // 使用了lambda表达式作为参数，允许类型参数可以推断出lambda表达式的类型。apply方法是Function接口的一个方法，它的作用是将一个参数应用到函数中，并返回计算结果。
  public static <T> void doSomething(T t, Function<T, T> function) {
      T result = function.apply(t);
      System.out.println(result);
  }

  public static void main(String[] args) {
      doSomething("hello", str -> str + " world!");
  }
}
