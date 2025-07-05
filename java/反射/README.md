# 反射

Java 的反射是一种能够在运行时动态获取和操作类、接口、方法和字段的能力。它允许程序在运行时获取类的结构，并且可以分析和调用类中的方法和成员变量。

反射机制可以使程序自省，可以检查自身的类和对象，并可以构造新的对象，以及调用他们的方法。反射是Java的核心机制之一，它为我们提供了一种操纵Java类的方式，从而可以更加灵活地使用Java类库。

## 使用 Class 对象时候需要注意哪些点？

- 首先要了解 class 对象的作用，它的作用是可以获取类的信息，包括其中的成员变量、方法等。
- 如果要使用 class 对象，必须先要确定类的名称，通过 Class.forName() 方法来获取 class 对象。
- 使用 class 对象可以获取类的成员变量、方法、构造器等信息，但是需要注意的是，获取到的成员变量、方法等信息可能是 private 的，需要使用不同的反射机制来访问和使用。

## Class 类介绍

在 Java 的反射应用中，最常见的就是对 Class 类的相关操作，那么下边让我们来系统性的认识下 Class 类具有哪些常用的反射接口。

```
String getName(): 返回类的完整名称，包括包名。
Class getSuperclass(): 返回当前类的直接父类。
Class getDeclaringClass(): 返回声明当前类的Class对象。
Class[] getInterfaces(): 返回当前类实现的接口Class对象数组。
int getModifiers(): 返回类的修饰符（public、private、protected等）。
Field[] getFields(): 返回类的公共属性。
Method[] getMethods(): 返回类的公共方法。
Constructor[] getConstructors(): 返回类的构造方法。
Field[] getDeclaredFields(): 返回类的所有属性（包括私有属性）。
Method[] getDeclaredMethods(): 返回类的所有方法（包括私有方法）。
Constructor[] getDeclaredConstructors(): 返回类的所有构造方法（包括私有构造方法）。
Object newInstance(): 创建实例。
```
