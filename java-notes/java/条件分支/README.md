# 条件判断 if else switch case

if else 

```java
int age = 18;
int money = 1000;

if (age > 16) {
  System.out.println("Age is valid.");
  if (money > 500) {
    System.out.println("You can buy a car.");
  } else if (money > 200) {
    System.out.println("You can buy a bike.");
  } else {
    System.out.println("You don't have enough money.");
  }
} else {
  System.out.println("Age is not valid.");
}

```

switch case

1. switch 语句只能使用字符串、枚举类型、整型和布尔类型。
2. switch 语句中的 case 标签必须是唯一的，不能重复。
3. switch 语句中必须有一个 default 标签，即使没有任何代码，也要声明一个default标签。
4. switch 语句中每个 case 标签后面必须要有 break ，否则会导致程序执行其后的所有代码。

```java
int age = 18;
switch (age) {
  case 18:
    System.out.println("小孩");
    break;
  case 19:
    System.out.println("青年");
    break;
  case 30:
    System.out.println("中年");
    break;
  case 45:
    System.out.println("中老年");
    break;
  default:
    System.out.println("老年");
    break;
}
```