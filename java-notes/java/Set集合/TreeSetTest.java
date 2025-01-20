
import java.util.TreeSet;

public class TreeSetTest {

  public static void main(String[] args) {
    // 创建TreeSet对象
    TreeSet<Integer> treeSet = new TreeSet<>();

    // 添加元素
    treeSet.add(2);
    treeSet.add(3);
    treeSet.add(5);
    treeSet.add(1);
    treeSet.add(4);
    // 遍历TreeSet
    for (Integer element : treeSet) {
      System.out.println(element);
    }
    // 查询最大值和最小值
    System.out.println("最小值：" + treeSet.first());
    System.out.println("最大值：" + treeSet.last());
    // 查询比3小的最大值
    System.out.println("比3小的最大值：" + treeSet.lower(3));
    // 查询比3大的最小值
    System.out.println("比3大的最小值：" + treeSet.higher(3));
    // 查询比3小的所有值
    System.out.println("比3小的所有值：" + treeSet.headSet(3));
    // 查询比3大的所有值
    System.out.println("比3大的所有值：" + treeSet.tailSet(3));
    // 删除元素
    treeSet.remove(3);
    System.out.println("删除后：" + treeSet);
  }
}
