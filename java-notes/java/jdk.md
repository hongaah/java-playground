# jdk 升级内容

随着Java市场的不断活跃，JDK版本的迭代也发生了非常多的变化，那么本章节中，我们重点来认识下JDK这些年的各个版本都有哪些特性，以及发生了怎样的变化。

JDK5
泛型（Generics），增强for循环（for-each loop），自动装箱、拆箱（Autoboxing/Unboxing），类型安全枚举（Type-Safe Enum），可变参数（Varargs），注解（Annotations）等。

JDK6
JDBC 4.0 API增强。
Java Compiler API，可以用 Java 代码编写 Java 代码。
Pluggable Annotation Processing API，用于在编译时扫描和处理注解。

JDK7
switch语句支持字符串。
改进的try-catch语法，可以一次捕捉多个异常。
支持二进制字面量表示。
自动资源管理，try-with-resources语句。
数字字面量中加下划线，从而增强了对数字字面量的可读性。

JDK8
Lambda表达式（Lambda Expressions）和方法引用（Method References）。
Stream API，使集合操作变得更加简单、快速且易于并行化。
接口默认方法（Default methods）。
类型注解（Type Annotations）。

JDK9
模块系统，提供更好的可视性和可靠性，以及更好的性能和安全性。
JShell，Java的Read-Eval-Print Loop（REPL）。
改进的Javadoc。

JDK10
局部变量类型推断（Local-Variable Type Inference）。
基于时间的版本控制（Time-Based Version-Control）。

JDK11
Unicode 10支持。
HTTP Client API。
基于命令行的作用域（Single-File Source-Code Programs）。

JDK12
switch表达式（Switch Expressions）的新语法，支持更加灵活的分支控制。
改进了shenandoah GC（Garbage Collector）的性能。

JDK13
改进了ZGC（Z Garbage Collector）的性能。
文本块（Text Blocks）的新语法。

JDK14
改进了Javadoc的HTML评注输出。
支持析构方法（Destructuring Declarations）。

JDK15
改进的文本块（Text Blocks）。
用于废弃现有GC算法的预览API。

JDK16
Record类，一种新的基于类的声明形式，用于将数据封装为对象。
将ZGC（Z Garbage Collector）扩展到Mac OS和Windows平台上。

JDK17
向Windows和Mac平台添加支持Cocoa OpenJDK工具包的API。
基于Java：FFI（Foreign Function and Interface），一种类型安全的，原生的嵌套语言交互方式。