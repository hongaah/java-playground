# List 集合

Java 集合框架定义了一系列接口和类，它们允许开发人员表示和操作集合数据结构(如列表、映射和集)，以便更高效地处理和存储数据。

Java 的 List 类型集合是指位于 java.util 包下的 List 接口，主要分类有两种，分别是 ArrayList 和 LinkedList 两个类

## 有了数组，为什么还要有集合的出现？

- 数组只能存储单一类型的数据，而集合可以存储多种类型的数据；
- 数组的长度是固定的，而集合的长度是可变的；
- 数组的存储操作比较复杂，而集合的存储操作比较简单；
- 数组不支持一些高级的操作，比如排序、查找等，而集合支持；
- 数组只能存储对象，而集合可以存储对象和基本数据类型。

## List 集合
 
List集合是Java中的一种数据结构，它是一个有序的集合，允许存储重复的元素。List集合的特点是可以按照索引来存储和访问元素，索引从0开始，而且可以根据需要随时增加和删除元素。List集合支持在列表中插入指定元素、查找指定元素索引、删除指定元素、替换指定元素等操作。

### ArrayList 和 LinkedList

由于我们的 List 集合定义只是一个接口类型，所以它的具体实现可以有多种，这里我们重点介绍下 List 接口下的两款集合类：ArrayList和LinkedList。

ArrayList 是基于数组实现的List集合，底层其实就是使用了一个数组进行的元素存储。当我们不断往ArrayList里面添加元素的时候，内部会有一个判断机制，判断数组的容量是否达到了一定阈值，如果达到了就会发生一个数组拷贝操作，将旧的数组的内容拷贝到新的数组里面去，这部分的操作会比较消耗性能，所以说它的插入和删除操作效率比较低。**但是采用数组进行存储，底层会有数组的索引下标存在，因此当我们需要根据索引下标去检索数据的时候，其效率会非常高。**

LinkedList 是基于双向链表实现的，当我们插入对象的时候，内部会创建一个新的节点对象，然后放入到一条链表的尾部，**由于没有牵扯到类似于ArrayList那样的数组拷贝操作，所以它的插入和删除操作效率比较高**。但是由于没有类似于数组的索引下标的存在，所以在进行数据检索的时候，效率会稍微弱一些。

```java
// 使用数组进行元素的添加时，我们需要指定不同的下标索引进行添加
// 使用数组管理元素的时候，其容量空间必须从一开始就控制好大小，假设我的数组容量为3，那么只能存储3个元素，倘若后期想再往数组里面添加新的元素，是会抛出 java.lang.ArrayIndexOutOfBoundsException 类型异常的。
String[] strs = new String[3];
strs[0] = "item0";
strs[1] = "item1";
strs[2] = "item2";

// 使用List进行元素添加的时候，我们只需要直接使用add方法
// 而使用List集合进行元素添加操作的时候，其内部会有自动扩容机制，这样我们就不需要去关心它内部的空间是否有限的问题了。
// List是否真的可以无限量添加元素？不行，List实际上有一个容量限制，即List的容量是受内存限制的，当内存的容量不够时，List就不能无限量添加元素了。
List<String> list = new ArrayList<>();
list.add("item1");
list.add("item2");
list.add("item3");
list.add("item4");
list.add("item5");
```

```java
// 创建List集合 
List<String> list = new ArrayList<String>(); 

// 向List集合尾部添加元素 
list.add("apple"); 

// 在指定位置添加元素 
list.add(1,"banana"); 

// 根据索引位置移除元素 
list.remove(1); 

// 根据元素内容移除元素 
list.remove("apple"); 

// 根据索引位置获取元素 
String fruit = list.get(0); 

// 根据索引位置修改元素 
list.set(0, "orange"); 

// 返回元素索引位置 
int index = list.indexOf("orange"); 

// 是否包含某元素
boolean contains = list.contains("orange"); 

// 返回List集合大小 
int size = list.size(); 

// 清空List集合元素 
list.clear(); 

// 判断List集合是否为空 
boolean isEmpty = list.isEmpty();

// 将List集合转换成数组 
String[] arr = list.toArray(new String[list.size()])

```