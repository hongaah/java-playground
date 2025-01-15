# 异常处理

Java中的异常类体系是由 Throwable 类及其子类构成的一个类层次结构。Throwable 类是 Java 语言中所有错误或异常的根类，它是 Java 语言中错误或异常处理的基础，其子类分为两大类：Error 类和 Exception 类。

异常处理的意义是保护程序的稳定性，避免因为异常情况而导致程序的瘫痪。它能够使程序发生异常时，能够及时处理异常，从而确保程序的正常运行。

## 关于catch部分有什么讲究吗？

catch块中的异常类型应该是精确的，不能使用父类的异常类型。比如，如果要捕获IOException，就不能使用Exception类型，应该使用IOException类型。

catch块中只能捕获一种异常类型，不能捕获多种异常类型。如果要捕获多种异常类型，可以使用多个catch块

如果要捕获多个异常类型，那么catch块中的异常类型应该从小到大排列。

```java
public void doSomething() {
  try {
    //执行一些代码
  } catch(IOException e) {
    //处理IOException异常 001
  } catch(NullPointerException e) {
    //处理NullPointerException异常 002
  } catch(Exception e) {
    //处理其他所有异常 003
  } finally {
    //不论是否发生异常，都要执行的代码 003
  }
}

```

## 常见的异常有哪些？

```java

// 空指针异常（NullPointerException）: 当程序试图在没有引用的对象上调用方法，或者试图访问或修改一个不存在的对象时，抛出此异常。
String str = null; 
System.out.println(str.length());

// 类型转换异常（ClassCastException）: 当一个类型的对象转换成不兼容的类型时，抛出此异常。
Object obj = new Object(); 
Integer i = (Integer)obj;

// 数组负下标异常（ArrayIndexOutOfBoundsException）: 当程序试图访问一个数组中不存在的索引时，抛出该异常。
int[] arr = new int[5];
System.out.println(arr[-1]);

// 数学异常（ArithmeticException）: 数学运算异常时抛出此异常。
int a = 1;
int b = 0;
int c = a/b;

// 算术异常（IllegalArgumentException）: 当传递给方法的参数不合法时，抛出此异常。
public static void test(int i) {
  if (i < 0) {
    throw new IllegalArgumentException("参数不能小于0");
  }
}

// 违反安全原则异常（SecurityException）: 当一个程序违反安全原则时，抛出此异常。
System.setProperty("java.security.policy", "your_policy.policy"); 
System.setSecurityManager(new SecurityManager()); 

// 文件未找到异常（FileNotFoundException）: 当程序尝试访问不存在的文件时，抛出此异常。
FileInputStream fis = new FileInputStream("abc.txt");

// 栈溢出异常（StackOverflowError）: 当程序堆栈溢出时，抛出此异常。
public static void stackOverflow(){
  stackOverflow();
}

// 字符串解析异常（NumberFormatException）: 当程序试图将字符串转换成不支持的数字格式时，抛出此异常。
String str = "abc";
int i = Integer.parseInt(str);

// 运行时异常（RuntimeException）: 所有可能在 Java 程序运行时发生的异常的基类
int a = 1;
int b = 0;
int c = a/b;
```
