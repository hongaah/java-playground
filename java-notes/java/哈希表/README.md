# 哈希表

哈希表（Hash Table）是一种数据结构，它利用哈希函数将键映射到特定的值，使用键快速检索数据。它也被称为散列表，哈希映射或哈希表。 Java中的哈希表是由Map接口实现的，它允许将键映射到值，其中每个键只能映射到一个值

### HashMap、Hashtable、LinkedHashMap 和 TreeMap

HashMap 是 Map 的基本实现，它支持快速查找和插入。是一种常用的哈希表实现，它使用哈希算法存储键值对，允许使用null值和null键，提供快速的查找和插入操作，不保证映射的顺序，特别是它不保证该顺序恒久不变。HashMap 是非线程安全的，不支持顺序遍历。

Hashtable 是一种线程安全的HashMap实现，它允许多个线程同时访问哈希表。是一种古老的哈希表实现，它使用哈希算法存储键值对，不允许使用null值和null键，提供快速的查找和插入操作，根据键的自然顺序进行排序，或者根据创建映射时提供的 Comparator 进行排序。HashTable 是线程安全的，不支持顺序遍历。

LinkedHashMap 是 HashMap 的子类，它使用链表来维护记录插入顺序，从而提供有序的访问。是一种哈希表实现，它使用哈希算法存储键值对，允许使用null值和null键，提供快速的查找和插入操作，使用元素的自然顺序或者根据提供的 Comparator 进行排序，这是哈希表和链表实现的一种组合。LinkedHashMap 支持顺序遍历，但不是线程安全的。

TreeMap使用红黑树（Red-Black Tree）来实现，它可以按照排序键来存储和访问记录，例如字母表顺序或数值顺序。是一种树实现，它使用比较器来存储键值对，不允许使用null值和null键，提供快速的查找和插入操作。TreeMap 支持顺序遍历，但不是线程安全的。

### 根据实际情况，可以根据以下几点来选择不同的哈希表实现：

是否需要线程安全性：如果需要，则可以选择HashTable；如果不需要，则可以选择HashMap或者LinkedHashMap等。

是否需要排序：如果需要，则可以选择TreeMap或者LinkedHashMap；如果不需要，则可以选择HashMap或者HashTable。

是否允许null值和null键：如果允许，则可以选择HashMap或者LinkedHashMap；如果不允许，则可以选择HashTable或者TreeMap。

### 你觉得哈希表和链表有什么区别吗？

哈希表和链表都是一种数据存储结构，但是它们有一些明显的不同之处。链表是一种顺序的数据结构，它可以实现有序的存储和访问，但是它的查找效率低下。

而哈希表是一种非顺序的数据结构，它使用哈希函数对数据进行存储，可以快速查找数据，但是它不能保证数据的有序性。此外，哈希表也具有更高的存储效率，因为它不需要额外的链接指针。

### 哈希表常用接口

1. put(K key, V value)：把指定的键值对存入map中
2. get(Object key)：返回指定键所映射的值
3. remove(Object key)：移除指定键所映射的键值对
4. containsKey(Object key)：如果map中包含指定的键，则返回true
5. containsValue(Object value)：如果map中包含指定的值，则返回true
6. size()：返回map中包含的键值对数量
7. isEmpty()：如果map为空，则返回true
8. keySet()：返回map中所有键的Set视图
9. values()：返回map中所有值的Collection视图
10. entrySet()：返回map中所有键值对的Set视图

### HashMap

HashMap 是 Java 中常用的数据结构，它实现了Map接口，同时也是一种哈希表。HashMap存储的内容是以键值对的形式存在的，其中键是唯一的，值则可以重复。它使用哈希算法来计算键值，来快速定位值。 HashMap支持高效的查找、插入和删除操作，并且没有固定的大小，在需要时会动态扩展。HashMap允许使用null作为键和值。此外，HashMap是非线程安全的，如果多个线程同时访问HashMap，可能会导致数据不一致。

```java
// put(key,value):添加元素
HashMap<String, String> map = new HashMap<String, String>(); 
map.put("1", "One"); 
map.put("2", "Two"); 
map.put("3", "Three");

// get(key):获取元素
String value = map.get("1"); 
System.out.println(value)

// remove(key):删除元素
map.remove("2");

// containsKey(key):判断是否包含key
if (map.containsKey("1")) { 
  System.out.println("map contains key 1"); 
}

// 检查值是否存在
boolean isExistValue = map.containsValue("Two");
System.out.println(isExistValue);

// 获取所有键的集合
Set<String> keySet = map.keySet();
for (String key : keySet) {
  System.out.println(key);
}

// 获取所有值的集合
Collection<String> values = map.values();
for (String item : values) {
  System.out.println(item);
}
```

### Hashtable

Hashtable 是一种线程安全的 HashMap 实现，可以让多个线程同时访问哈希表。

Hashtable 是 Java 中古老的集合类，实现了 Map 接口，是一种基于散列表的线程安全的存储结构。它是一种实现了基本 Map 操作（put()、get()、remove()等）的实现，而且 Hashtable 是线程安全的。 Hashtable 的实现原理是将 key 和 value 映射到哈希表中，哈希表中的每一个位置叫做桶，每一个桶中存储了一个键值对，当我们添加一个键值对时，首先会根据 key 计算出 hashcode，然后根据 hashcode 计算出在哈希表中的位置，最后将键值对存储到对应的位置中，当我们查找时，就能够快速的定位到对应的位置，从而加快查找的速度。

其实我觉得 HashTable 就是早期版本的 HashMap，只不过它的各种操作接口都是具备线程安全性的，所以它的性能相对于 HashMap 来说会比较低一些。

```java
Hashtable<String, Integer> table = new Hashtable<>();
table.put("John", 21);
table.put("Alice", 25);
table.put("Bob", 27);

// Retrieve the value associated with key "John"
int age = table.get("John"); // age = 21

// remove(key):删除元素
table.remove("Bob");

// 更新元素
table.replace("Alice"， 18);

// containsKey(key):判断是否包含某个key
if (table.containsKey("John")) { 
  System.out.println("hashtable contains key John"); 
}
```

### LinkedHashMap

LinkedHashMap 可以使用链表来维护记录的插入顺序，从而提供有序的访问

LinkedHashMap 是 Java 中的一种散列表实现，它继承自 HashMap 类，同时实现了根据访问顺序来存储映射的功能。它使用双向链表来维护访问顺序，当我们遍历 LinkedHashMap 时，其元素将以其被插入的顺序进行遍历。

你可以理解为，LinkedHashMap 就是 HashMap + LinkedList，它的底层存储基本上还是和 HashMap 相同，只是在插入元素和查找元素的时候，需要使用到一条额外的双向链表 LinkedList。

LinkedHashMap 中使用 LinkedList 的目的是为了维护访问顺序。LinkedHashMap 使用双向链表维护Map中键值对的访问顺序，以便当我们遍历该 Map 时，可以按照元素被插入的顺序来进行遍历。

```java
LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(); 
map.put("1", "One");
map.put("2", "Two"); 
map.put("3", "Three");

String value = map.get("1"); 
System.out.println(value); 

map.remove("2");

if (map.containsKey("1")) {
  System.out.println("map contains key 1"); 
}

// 遍历linkedHashMap中的值
for(String key : map.keySet()) {
  System.out.println("Key : " + key + " Value : " + linkedHashMap.get(key));
}
```

### TreeMap

TreeMap 可以按照排序键来存储和访问记录。

TreeMap 是 Java 中的一种映射实现，它把键映射到值。TreeMap 是一种有序的键值映射，它使用红黑树结构来存储键，以便保持按键的自然顺序排列，而不是按照插入顺序排列。

TreeMap 支持键的比较，但不支持值的比较。TreeMap 中的键值对是不可变的，因此它们不能被改变，只能被添加和删除。TreeMap 是非线程安全的，因此在多线程环境中使用时需要注意同步。

```java
TreeMap<String, String> map = new TreeMap<String, String>(); 
map.put("1", "One"); 
map.put("2", "Two"); 
map.put("3", "Three");

String value = map.get("1"); 
System.out.println(value); 

map.remove("1");

if (map.containsKey("1")) { 
  System.out.println("map contains key 1"); 
}

//检查 map 是否包含指定的值
boolean hasValue = map.containsValue('Two');
System.out.println(hasValue); // true

//获取 map 中键值对的数量
int size = map.size();
System.out.println(size); // 2

//遍历 map 中的所有键
for (String key : map.keySet()) {
    System.out.println(key); // Apple Orange
}

//遍历 map 中的所有值
for (Integer valueItem : map.values()) {
    System.out.println(valueItem); // 1 3
}

//遍历 map 中的所有键值对
for (Map.Entry<String, Integer> entry : map.entrySet()) {
  System.out.println(entry.getKey() + " = " + entry.getValue()); // Apple = 1 Orange = 3
}
```
