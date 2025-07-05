import java.util.Arrays;

public class Test {

  // 枚举类型是一种特殊的类，用于表示一组固定的常量。
  public enum Season {
    WINTER, SPRING, SUMMER, FALL
  };

  public static void main(String[] args){

    // values方法
    Season[] vals = Season.values();
    // vals = {WINTER, SPRING, SUMMER, FALL}

    // valueOf方法
    Season val = Season.valueOf("SUMMER");
    // val = SUMMER

    //  直接打印数组对象会输出其内存地址，而不是数组的内容。可以使用 Arrays.toString() 方法来打印数组内容。
    // System.out.println("values方法 " + vals);
    System.out.println("values方法 " + Arrays.toString(vals));
    System.out.println("valueOf方法 " + val);
  }
}
