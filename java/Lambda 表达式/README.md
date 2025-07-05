# Lambda 表达式

Lambda 表达式是 Java 8 开始支持的一种新语法，它使编程更简洁，支持函数式编程，可以支持多种函数式语言特性，如函数作为参数、函数式接口等。Lambda 表达式使得编程更加简洁，可以减少代码量，提高代码的可读性，更加易于维护。

## Lambda 表达式语法和应用

语法：
它包含三部分：参数列表、箭头符号和表达式或语句块。
其中参数列表是可选的；如果没有参数，则括号可以省略；如果表达式只有一个可以不用括号，如果有多个参数则必须使用括号。

```java
(parameters) -> expression
(parameters) -> { statements1;statements2; }
```

常用方式：
- 函数式接口：只有一个抽象方法的接口，可以使用lambda表达式。 🌰: LambdaDemo.java
- 类型参数：使用lambda表达式作为参数，允许类型参数可以推断出lambda表达式的类型。 🌰: LambdaTypeDemo.java
- 函数式方法：可以使用lambda表达式作为方法参数，以实现函数式接口。 🌰: LambdaMethodDemo.java

所有在 Java 中带有 @FunctionalInterface 注解修饰的接口，都可以使用 lambda 表达式来调用，例如我们线程里面常用的 Runnable 类：

```java
public static void main(String[] args) {
    new Thread(()->System.out.println("this is runnable test 1")).start();
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("this is runnable test 2");
        }
    });
    thread.start();
}
```

## Lambda表达式的优点

Java lambda表达式是一种新的、非常简洁的语法，用来表示一个函数接口的实例，即只有一个抽象方法的接口。它使用一对圆括号（）和一个箭头->来表示，其中参数在左侧，函数体在右侧。

关于它的优点，我总结了下，大概有以下几项：

- lambda表达式可以用来实现复杂的业务逻辑，例如多线程、数据流和异步处理；
- lambda表达式可以让代码更加简洁，减少代码量，提高代码可读性；
- lambda表达式可以在Stream API、Collection API等类库中使用，可以更加高效地处理集合等复杂数据结构。
