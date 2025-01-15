# 哈希表

哈希表（Hash Table）是一种数据结构，它利用哈希函数将键映射到特定的值，使用键快速检索数据。它也被称为散列表，哈希映射或哈希表。 Java中的哈希表是由Map接口实现的，它允许将键映射到值，其中每个键只能映射到一个值

## HashMap、Hashtable、LinkedHashMap 和 TreeMap

HashMap 是 Map 的基本实现，它支持快速查找和插入。是一种常用的哈希表实现，它使用哈希算法存储键值对，允许使用null值和null键，提供快速的查找和插入操作。HashMap 是非线程安全的，不支持顺序遍历。

Hashtable 是一种线程安全的HashMap实现，它允许多个线程同时访问哈希表。是一种古老的哈希表实现，它使用哈希算法存储键值对，不允许使用null值和null键，提供快速的查找和插入操作。HashTable 是线程安全的，不支持顺序遍历。

LinkedHashMap 是 HashMap 的子类，它使用链表来维护记录插入顺序，从而提供有序的访问。是一种哈希表实现，它使用哈希算法存储键值对，允许使用null值和null键，提供快速的查找和插入操作。LinkedHashMap 支持顺序遍历，但不是线程安全的。

TreeMap使用红黑树（Red-Black Tree）来实现，它可以按照排序键来存储和访问记录，例如字母表顺序或数值顺序。是一种树实现，它使用比较器来存储键值对，不允许使用null值和null键，提供快速的查找和插入操作。TreeMap 支持顺序遍历，但不是线程安全的。

## 根据实际情况，可以根据以下几点来选择不同的哈希表实现：

是否需要线程安全性：如果需要，则可以选择HashTable；如果不需要，则可以选择HashMap或者LinkedHashMap等。

是否需要排序：如果需要，则可以选择TreeMap或者LinkedHashMap；如果不需要，则可以选择HashMap或者HashTable。

是否允许null值和null键：如果允许，则可以选择HashMap或者LinkedHashMap；如果不允许，则可以选择HashTable或者TreeMap。

### HashMap

HashMap 可用于存储键值对

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
```

### Hashtable

Hashtable 是一种线程安全的 HashMap 实现，可以让多个线程同时访问哈希表

```java
Hashtable<String, Integer> table = new Hashtable<>();
table.put("John", 21);
table.put("Alice", 25);
table.put("Bob", 27);

// Retrieve the value associated with key "John"
int age = table.get("John"); // age = 21

// remove(key):删除元素
table.remove("Bob");

// containsKey(key):判断是否包含某个key
if (table.containsKey("John")) { 
  System.out.println("hashtable contains key John"); 
}
```

### LinkedHashMap

LinkedHashMap 可以使用链表来维护记录的插入顺序，从而提供有序的访问

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
```

### TreeMap

TreeMap可以按照排序键来存储和访问记录

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
```
