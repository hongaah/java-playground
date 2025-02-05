# Stream

Java 中的 Stream 是一种新的抽象数据类型，它允许程序员以声明式的方式处理数据，而不需要编写繁琐的循环代码。Stream 可以支持顺序或并行的处理操作，并支持高效的内存消耗。

Stream 可以从一个数据源（如集合，数组，文件等）中获取数据，然后对数据进行各种处理，最后将处理结果输出到控制台或文件中。Stream 提供了一系列非常有用的操作，如 map，filter，reduce，collect 等，可以极大地提高编程效率。

## Stream 常用函数的介绍

Java中的 Stream 常用函数主要有以下几类： 🌰: StreamDemo.java

filter：根据条件过滤数据；
map：将一个流中的值转换成另一个流；
limit：获取指定数量的数据；
sorted：对流中的元素进行排序；
distinct：根据流中元素的hashCode和equals去重；
forEach：遍历流中的每一个数据；
collect：将流转换为其他形式，接收一个 Collector 接口的实现，用于给 Stream 中元素做汇总的方法；比如可以将原先以List结构进行存储的数据转换为以Map，Set等多种功能结构的存储方式
min/max：获取流中的最大/最小值；
count：获取流中元素的个数；
anyMatch：是否存在满足条件的元素；
allMatch：流中元素是否都满足条件；
noneMatch：流中元素是否都不满足条件。

```java
// 获取testNumberList中最大的两位数字
public static void main(String[] args) {
    List<Integer> testNumberList = new ArrayList<>();
    testNumberList.add(1);
    testNumberList.add(22);
    testNumberList.add(11);
    testNumberList.add(4);
    testNumberList.add(123);
    //如何获取最大的两位数字
    System.out.println(testNumberList.stream().sorted((x1,x2)-> x2-x1).limit(2).collect(Collectors.toList()));
}

```