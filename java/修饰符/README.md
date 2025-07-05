# 修饰符

## 三种修饰符

Java的三种基本修饰符是public、protected和private。它们可以控制不同类中变量和方法的访问权限，以保护程序的安全性。

public 修饰符用于指定类、方法、变量可以被任何类访问。
protected 修饰符用于指定类、方法、变量可以被同一个包中的类以及所有子类访问。
private 修饰符用于指定类、方法、变量只能被同一个类中的方法访问。

## static 修饰符

static 变量和传统的类属性变量有什么区别吗？

主要有以下几点：
static 修饰的变量是属于整个类所有，而不是某个对象所有。
static 修饰的变量可以被所有对象所共享，普通的类变量只能被定义该变量的对象共享。
static 修饰的变量可以直接用类名调用，而普通的类变量则需要通过实例调用。

## final 修饰符

final 修饰符是一种 Java 关键字，用于修饰类、变量和方法，用来限定其不能被继承、修改或删除。可以用来保护代码和数据的安全性。

final 修饰符在以下几种场景中可以具体使用： 
1. 类：当声明一个类为 final 时，它就成为一个不可变类，不能被其它类继承。 
2. 方法：当声明一个方法为 final 时，它就不能被子类重写。 
3. 变量：当声明一个变量为 final 时，它就成为一个常量，不能被修改。

使用final修饰符的时候需要注意以下几点：
- 不要试图修改一个 final 变量，因为它是一个常量，只能被初始化一次。
- 当使用 final 修饰符修饰一个方法时，该方法就不能被子类重写。
- 不要尝试继承一个 final 类，因为它不能被继承。
- 尽量不要把一个类声明为 final，因为这样会限制类的扩展性。

```
[modifier] final class ClassName
[modifier] final [type] variableName
[modifier] final returnType methodName(parameters)
```

- modifier 表示修饰符，可以是public、protected、private或者什么都不写；
- type 表示变量的类型；
- returnType 表示方法的返回值类型；
- parameters 表示方法的参数列表。

```java
public final class MyClass {
  public final int MAX_VALUE = 100;
  public int value;

  public MyClass(int value) {
    this.value = value;
  }

  public final void increaseValue() {
    if (this.value < MAX_VALUE)
      this.value++;
  }
}

```
