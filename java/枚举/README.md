# 枚举

枚举是Java中的一种特殊的类，它可以用来定义一组有限的常量，每个常量可以表示一个特定的值。

枚举类型的定义方式是通过使用enum关键字来定义的，它是一种类型，可以像使用其他类型一样使用枚举。枚举可以定义各种属性和方法，可以像普通类一样定义构造器，实现接口，以及定义任意方法。

## Java中的枚举类型可以继承吗？

枚举类型其实是一种特殊的类，它的实例是固定的，无法被继承。枚举类型的实例使用enum关键字定义，它们在设计的时候是不能被二次修改，所以如果我们希望修改枚举中某个属性的值，是实现不了的。

## 语法

```java
public enum Season {
  WINTER, SPRING, SUMMER, FALL
}

// 使用枚举变量 枚举可以像普通类型一样使用
Season season = Season.SUMMER;

// 使用switch语句
switch (season) {
  case WINTER:
    System.out.println("It's Winter.");
    break;
  case SPRING:
    System.out.println("It's Spring");
    break;
  case SUMMER:
    System.out.println("It's Summer");
    break;
  case FALL:
    System.out.println("It's Fall");
    break;
}

// 遍历 获取枚举的所有值
for (Season s : Season.values()) {
  System.out.println(s);
}

// 比较枚举
if (season == Season.SUMMER) {
  System.out.println("It's summer!");
}

// 区分 values 和 valueOf 方法
// values方法 用于返回一个包含枚举值得枚举数组
Season[] vals = Season.values();
// vals = {Spring, Summer, Autumn, Winter}

// valueOf方法 用于根据枚举的名字来返回对应的枚举值
Season val = Season.valueOf("Summer");
// val = Summer
```
