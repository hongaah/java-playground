# Set集合

Set 集合是 Java 中的一种特殊的集合，它不允许集合中出现重复元素。Set 集合中的元素是无序的，不可重复的，没有索引。

Set 集合本身的定义是一个接口类型，但是其下可以使用 HashSet、TreeSet 等实现，其中HashSet提供了最快的查找和插入速度，而 TreeSet 则提供了有序的元素组织。Set 集合的常用方法有add()、remove()、contains()、isEmpty()等。

## HashSet

HashSet 是 Java 中的一种 Set 接口实现，它不允许集合中有重复的元素。它使用哈希表实现，允许插入和检索操作的时间复杂度为O(1)。

它的实现是基于哈希函数的，因此元素的存储次序与插入次序无关，而且比较两个元素时，不需要使用 equals() 方法，只需要调用 hashCode() 方法就可以判断两个元素是否相等。

它的一个优势是，它可以检测集合中的重复元素，因此不会出现重复的元素。另外，它也可以快速检索元素，因为它使用哈希函数来存储元素，因此可以快速检索元素。

[HashSet API](./HashSet%20API.md)

## TreeSet 集合

TreeSet是java.util包中的一个集合类，它继承自AbstractSet，是基于TreeMap实现的，TreeSet中的元素是按照元素的自然顺序排序的，或者根据构造函数传入的Comparator进行排序的。

TreeSet不允许集合中存在重复元素，它提供了多种操作集合元素的方法，如添加、删除、查找等，还提供了多种不同的迭代器，可以用Iterator或ListIterator迭代TreeSet中的元素。

[TreeSet API](./TreeSet%20API.md)
