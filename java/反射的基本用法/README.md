# 反射的基本用法

## Field 对象

Field 类是 Java 反射 API 中的一个类，它表示类或接口的成员变量（包括公共、保护、默认（包）访问和私有成员变量）。可以通过 Field 类的实例获取和设置类中对象的属性值。它提供了一些方法来访问和操作类的成员变量。该类主要有以下几个方法：

```java
String getName()：获取此 Field 对象表示的成员变量的名称；
Class getType()：获取此 Field 对象表示的成员变量的声明类型；
int getModifiers()：获取此 Field 对象表示的成员变量的 Java 语言修饰符；
Object get()：获取此 Field 对象表示的成员变量的值；
void set()：设置此 Field 对象表示的成员变量的值；
boolean isAnnotationPresent()：判断此 Field 对象是否被指定类型的 Annotation 所注释。
```

## Method 对象

Method 类是 Java 反射 Api 中非常重要的类，它表示类中某一个方法的定义。Method 类提供了一些方法用于访问和操作类中定义的方法，如：getName()、getParameterTypes()、invoke()等。

通过 Method 类可以调用类中定义的方法，研究类中定义的一些方法，获取方法的参数和返回值，以及实现动态代理等功能。该类主要有以下几个方法：

```java
String getName()：返回此方法的名称。
Class<?>[] getParameterTypes()：返回一个包含此方法参数类型的数组。
Class<?> getReturnType()：返回一个 Class 对象，它标识了此 Method 对象所表示的方法的返回类型。
Object invoke(Object obj, Object... args)：调用指定对象上的该方法，并传入指定参数。参数：obj-调用该方法的对象，args-方法参数
```

## 使用 Field 和 Method 对象时需要注意哪些点

- 在使用 Field 时，必须确保它们存在，否则可能会导致程序崩溃。例如使用 getDeclaredField 获取一个不存在的属性，则会引起异常。
- 在使用 Method 访问私有方法 invoke 的时候，要记得将其权限设置为可访问状态，即调用 method.setAccessible(true) 方法。
