public class LambdaMethodDemo {
  public static void doSomething2(String str, Function<String, String> function) {
     String result = function.apply(str);
     System.out.println(result);
  }

   public static void main(String[] args) {
      doSomething2("hello", str -> str.toUpperCase());
   }
}
