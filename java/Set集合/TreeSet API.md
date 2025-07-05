# TreeSet 集合 API

```java
TreeSet<String> treeSet = new TreeSet<>();

// 添加元素
treeSet.add("Apple");
treeSet.add("Banana");

// 删除指定的元素
treeSet.remove("Apple");

// 判断是否存在指定的元素
boolean isContain = treeSet.contains("Apple");

// 判断一个集合的体积
int size = treeSet.size();

// 判断一个集合是否为空
boolean isEmpty = treeSet.isEmpty();

// 清空一个集合
treeSet.clear();

// 获取集合中的第一个元素
String first = treeSet.first();

// 获取集合中的最后一个元素
String last = treeSet.last();

// 返回集合中小于指定元素的子集合
TreeSet<String> headSet = treeSet.headSet("Orange");

// 返回集合中大于指定元素的子集合
TreeSet<String> tailSet = treeSet.tailSet("Banana");

// 返回集合中指定区间的子集合
TreeSet<String> subSet = treeSet.subSet("Apple", "Orange");

// 返回集合的降序视图
TreeSet<String> descendingSet = treeSet.descendingSet();

// 返回集合的迭代器
Iterator<String> iterator = treeSet.iterator();

// 返回集合的降序视图的迭代器
Iterator<String> descendingIterator = treeSet.descendingIterator();
```
