# 队列

队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。队列中的元素遵循先进先出（FIFO）的原则，即先插入的元素先取出，后插入的元素后取出

## 什么场景下会使用队列呢？

- 操作系统中的任务调度，可以利用队列的先进先出特性来有序地执行不同的任务。
- 消息中间件，队列可以存储消息，接收者可以按照先进先出的原则消费消息。
- 调度任务，用于存储任务，可以按照任务进入队列的顺序来执行它们。
- 网络缓冲，可以利用队列来存储网络请求，以便按照先进先出的原则进行请求处理。

## Queue 接口的基本定义

Queue 接口是 Java 中定义的一个接口，用于描述队列的行为。它继承了 Collection 接口，所以它也是一个集合。它定义了一系列用于操作队列的常用方法，比如添加元素、获取元素、检查队列是否为空等，具体接口描述如下所列：

```java
Queue<String> queue = new LinkedList<>();

void add(E e)：将指定元素添加到此队列中。
boolean offer(E e)：如果可以在不违反容量限制的情况下立即将指定元素插入此队列中，则返回true，否则返回false。
E remove()：移除并返回此队列的头部。
E poll()：移除并返回此队列的头部，如果此队列为空，则返回null。
E element()：返回此队列的头部。
E peek()：返回此队列的头部，如果此队列为空，则返回null。
boolean contains(Object o)：如果此队列包含指定的元素，则返回true。
int size()：返回此队列中的元素数量。
boolean isEmpty()：如果此队列不包含元素，则返回true。
```

## Deque 接口的基本定义

Deque 接口是一个双端队列的定义，可以从两端添加和删除元素。它定义了一组操作，可以从队列的头部或尾部添加和删除元素，包括检查元素，以及检查队列的大小。

Deque 接口提供的操作包括：添加、移除、检查和元素替换。它支持阻塞添加和移除操作，还支持定时操作。它继承了 Queue 接口，提供了一些额外的基于双端队列的操作方法，例如添加到队列开头、添加到队列末尾等，具体的接口描述如下所列：

```java
import java.util.Deque;
import java.util.LinkedList;

Deque<String> deque = new LinkedList<>();

void addFirst(E e)：将指定元素插入到此双端队列的开头。
void addLast(E e)：将指定元素插入到此双端队列的末尾。
boolean offerFirst(E e)：将指定元素插入到此双端队列的开头，如果操作成功返回true，否则返回false
boolean offerLast(E e)：将指定元素插入到此双端队列的末尾，如果操作成功返回true，否则返回false。
E removeFirst()：移除并返回此双端队列的第一个元素。
E removeLast()：移除并返回此双端队列的最后一个元素。
E pollFirst()：移除并返回此双端队列的第一个元素，如果操作成功返回元素，否则返回null。
E pollLast()：移除并返回此双端队列的最后一个元素，如果操作成功返回元素，否则返回null。
E getFirst()：返回此双端队列的第一个元素。
E getLast()：返回此双端队列的最后一个元素。
E peekFirst()：返回此双端队列的第一个元素，如果操作成功返回元素，否则返回null。
E peekLast()：返回此双端队列的最后一个元素，如果操作成功返回元素，否则返回null。
boolean removeFirstOccurrence(Object o)：从此双端队列的开头移除第一次出现的指定元素（如果存在）。
boolean removeLastOccurrence(Object o)：从此双端队列的末尾移除最后一次出现的指定元素（如果存在）。
boolean add(E e)：将指定元素插入到此双端队列的末尾。
boolean offer(E e)：将指定元素插入到此双端队列的末尾，如果操作成功返回true，否则返回false。
E remove()：移除并返回此双端队列的第一个元素。
E poll()：移除并返回此双端队列的第一个元素，如果操作成功返回元素，否则返回null。
E element()：返回此双端队列的第一个元素。
E peek()：返回此双端队列的第一个元素，如果操作成功返回元素，否则返回null。
void push(E e)：将元素推入此双端队列所表示的堆栈（插入到双端队列的头部）。
E pop()：从此双端队列所表示的堆栈中弹出一个元素（移除并返回双端队列的头部）。
boolean remove(Object o)：从此双端队列移除首次出现的指定元素。
Iterator descendingIterator()：返回以逆序地遍历此双端队列的迭代器。
boolean contains(Object o)：如果此双端队列包含指定的元素，则返回true。
int size()：返回此双端队列中的元素数量。
boolean isEmpty()：如果此双端队列不包含元素，则返回true。
```

## Java 中常见的队列类

Java 中常用的队列实现类有 LinkedList、ArrayDeque、PriorityQueue等。

LinkedList 是一个双端链表，它实现了 Queue 和 Deque 接口，可以从头尾进行插入或删除操作。
ArrayDeque 是一个动态数组，它实现了 Deque 接口，可以从头尾进行插入或删除操作。
PriorityQueue 是一个基于优先级的队列，它实现了 Queue 接口，可以根据优先级对队列中的元素进行排序。

### LinkedList

在 <java-notes\java\List集合\README.md> 中，我们知道 LinkedList 作为一款基于链表结构的 List 集合，但是其实它的底层也实现了 Queue 接口的基本操作。所以 LinedList 也可以作为一款队列去进行使用，下边是它的使用代码案例：

```java
public static void main(String[] args) {
  LinkedList<String> queue = new LinkedList<>();

  // 入队
  queue.add("A");
  queue.add("B");
  queue.add("C");

  // 出队
  String first = queue.removeFirst();
  System.out.println("出队元素：" + first);

  // 获取队首元素
  String head = queue.getFirst();
  System.out.println("队首元素：" + head);

  // 查看队列大小
  int size = queue.size();
  System.out.println("队列大小：" + size);
}
```

### ArrayDeque

ArrayDeque 是一种双端队列（Deque）实现，它使用一个动态数组来存储元素。它允许添加和删除元素从两端，允许快速访问队列头部（head）和队列尾部（tail）元素。它拥有O（1）时间复杂度的插入和删除操作，拥有O（n）时间复杂度的搜索操作。

```java
public static void main(String[] args) {
  // 创建一个ArrayDeque
  ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

  // 向ArrayDeque中添加元素
  arrayDeque.add(1);
  arrayDeque.add(2);
  arrayDeque.add(3);

  // 从ArrayDeque中获取元素
  int first = arrayDeque.removeFirst();
  System.out.println(first);

  int last = arrayDeque.removeLast();
  System.out.println(last);
}

```

### PriorityQueue

PriorityQueue 是 Java 中的一种特殊的队列，它的内部实现是一个基于优先级堆的数据结构。优先级队列中的元素可以按照它们之间的比较函数进行排序，而不是按照它们插入队列的顺序。这种队列的作用是可以按照它们的优先级进行访问，而不是按照先进先出的顺序。

```java
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
  public static void main(String[] args) {
    // 使用优先级队列创建一个学生信息的统计
    PriorityQueue<Student> students = new PriorityQueue<>(new Comparator<Student>() {
      @Override
      public int compare(Student s1, Student s2) {
        //如果这里是s2的分数大于s1的分数，就会返回正数，从而会形成成绩倒序的效果
        return s2.getScore() - s1.getScore();
      }
    });

    students.offer(new Student("小明", 80));
    students.offer(new Student("小红", 90));
    students.offer(new Student("小王", 50));
    students.offer(new Student("小李", 100));
    students.offer(new Student("小刚", 70));

    // 根据考试分数高低来排序
    while (!students.isEmpty()) {
      Student student = students.poll();
      System.out.println(student.getName() + "的分数是：" + student.getScore());
    }
  }
}

class Student {
  private String name;
  private int score;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }
}

```
