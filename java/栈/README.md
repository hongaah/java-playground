# 栈

栈结构是一种限制插入和删除操作的线性结构，具有后入先出（LIFO）的特性。它的特点是只允许在表的一端进行插入和删除操作，这一端被称为栈顶，另一端被称为栈底，每次插入和删除操作都只能在栈顶进行，而且每次只能从栈顶删除一个元素，因此满足后入先出（LIFO）的原则。如下图所示，最后放入的元素a，也是第一个会被弹出的元素。

## java.utils.Stack

Java中的栈可以使用java.util.Stack类来实现。Stack类提供了一系列的方法来操作栈，如push()、pop()、peek()等。它们分别用于压入、弹出、查看栈顶元素等操作。

```java
public static void main(String[] args) {
  // 创建一个栈
  Stack<Integer> stack = new Stack<>();

  // 压入元素
  stack.push(1);
  stack.push(2);
  stack.push(3);

  // 弹出栈顶元素
  Integer top = stack.pop();
  System.out.println(top); 

  // 查看栈顶元素
  Integer peek = stack.peek();
  System.out.println(peek);

  // 检查栈是否为空
  boolean isEmpty = stack.isEmpty();
  System.out.println(isEmpty); 

  // 查找元素
  int index = stack.search(2);
  System.out.println(index); 
}

```

## Java中的栈结构使用的时候有哪些注意点

- 栈是一种先进后出的数据结构，这意味着当添加或获取元素时，最后添加的元素将是第一个被取出的元素。
- 栈的大小是有限的，必须提前设定，一旦栈的大小设定了就不能再改变了。
- 在使用栈时应避免溢出，即在添加元素时应检查栈是否已满。
- 同样，在获取元素时也应检查栈是否为空，以避免空指针异常。
- 在使用栈时应尽量简化代码，以避免出现错误。
