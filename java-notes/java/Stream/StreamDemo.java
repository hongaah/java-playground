import java.util.*;
import java.util.stream.Collectors;

public class StreamFilterDemo {

    private static List<Integer> numberList = new ArrayList<Integer>();

    static {
        numberList.add(1);
        numberList.add(9);
        numberList.add(3);
    }

    public static void allDemo() {
        // List<Integer> resultList = numberList.stream().filter(x -> x > 2).collect(Collectors.toList());

        // List<Integer> resultList = numberList.stream().map(x -> Integer.valueOf(x) + 1).collect(Collectors.toList());

        // 取出队列中的前 n 个元素 limit 用法
        // System.out.println(numberList.stream().limit(3).collect(Collectors.toList()));

        //默认是升序排序
        // System.out.println(numberList.stream().sorted().collect(Collectors.toList()));

        //去重
        // System.out.println(numberList.stream().distinct().collect(Collectors.toList()));

        // System.out.println(resultList);

        numberList.stream().forEach(x -> {
          int j = x + 1;
          System.out.println(j);
        });

    }
 
    public static void collectDemo() {
      Map<Integer, Integer> resultMap = numberList.stream().collect(Collectors.toMap(Integer::intValue, x -> x));
      System.out.println(resultMap);

      Map<Integer, List<Integer>> listTypeMap = numberList.stream().collect(Collectors.groupingBy(x -> x.intValue()));
      System.out.println(listTypeMap);

      Set<Integer> resultSet = numberList.stream().collect(Collectors.toSet());
      System.out.println(resultSet);
    }

    public static void countDemo() {
      System.out.println(numberList.stream().max(Integer::compareTo).get());
      System.out.println(numberList.stream().min(Integer::compareTo).get());
      System.out.println(numberList.stream().count());
    }

    public static void matchDemo() {
      System.out.println(numberList.stream().anyMatch(x -> x > 100));
      System.out.println(numberList.stream().allMatch(x -> x > 100));
      System.out.println(numberList.stream().noneMatch(x -> x > 100));
    }

    public static void main(String[] args) {
        // allDemo();
        // collectDemo();
        countDemo();
        matchDemo();
    }
 }
