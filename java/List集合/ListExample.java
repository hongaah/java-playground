import java.util.ArrayList;
import java.util.List;

public class ListExample {
  public static void main(String[] args) {
    // 创建一个List集合
    List<String> list = new ArrayList<>();

    // 添加元素
    list.add("Hello");
    list.add("World");
    list.add("!");

    // 输出List集合中的元素
    System.out.println("List集合中的元素: ");
    for (String str : list) {
      System.out.println(str);
    }
  }
}
