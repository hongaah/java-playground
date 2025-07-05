
import java.util.HashSet;
import java.util.Set;

public class SetExample {
  public static void main(String[] args) {
    // 创建Set集合
    Set<String> set = new HashSet<>();
    // 添加元素
    set.add("Apple");
    set.add("Banana");
    set.add("Pear");
    // 删除元素
    set.remove("Banana");
    // 检查元素是否存在
    if (set.contains("Pear")) {
      System.out.println("Pear exists");
    }
    // 检查Set集合是否为空
    if (set.isEmpty()) {
      System.out.println("Set is empty");
    }
  }
}
