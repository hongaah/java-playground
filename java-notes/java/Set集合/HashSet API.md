# HashSet 集合 API

```java

// 创建一个 HashSet
HashSet<Integer> set = new HashSet<>();
HashSet<Integer> set1 = new HashSet<>();

// 向 HashSet 中添加元素
set.add(1);
set.add(2);
set.add(3);
set1.add(1);
set1.add(2);

// 通过 remove() 方法从 HashSet 中删除元素
if (set.contains(2)) {
  set.remove(2);
}

// 检查HashSet是否为空
if (set.isEmpty()) {
  System.out.println("HashSet为空");
}

// 获取HashSet的大小
int size = set.size();
System.out.println("HashSet中元素的数量是：" + size);

// 清空HashSet中的所有元素
set.clear();

// 比较两个HashSet是否相等
if (set.equals(set1)) {
  System.out.println("两个HashSet相等");
}

// 计算HashSet的哈希码
int hashCode = set.hashCode();
System.out.println("HashSet的哈希码是：" + hashCode);

// 获取HashSet的迭代器
Iterator<Integer> iterator = set.iterator();
// 遍历HashSet中的元素
while (iterator.hasNext()) {
  System.out.println(iterator.next());
}

```
