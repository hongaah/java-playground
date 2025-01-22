# 属性描述器

PropertyDescriptor 是 Java 类库中的一个实用工具类，用于描述 JavaBean 中的属性。它可以用于获取指定属性的属性描述符，以进行更高级的功能操作，如获取属性的名称、类型、读写方法等。 

PropertyDescriptor 提供了两个构造函数：
1. 传入属性名称和对象，用于获取指定属性的属性描述符：

```java
public PropertyDescriptor(String propertyName, Class<?> beanClass)
```

2. 传入属性名称、读取方法名称、写入方法名称和对象，用于获取指定属性的属性描述符

```java
public PropertyDescriptor(String propertyName, Method readMethod, Method writeMethod)
```

PropertyDescriptor 提供了一些用于操作属性描述符的方法，例如：getPropertyType() 获取属性类型，getReadMethod() 获取读方法，getWriteMethod() 获取写方法等。

```java
String getName()：获取属性名称。
Class<?> getPropertyType()：获取属性类型。
Method getReadMethod()：获取读取方法。
Method getWriteMethod()：获取写入方法。
void setReadMethod(Method readMethod)：设置读取方法。
void setWriteMethod(Method writeMethod)：设置写入方法。
void setPropertyEditorClass(Class<?> propertyEditorClass)：设置属性编辑器类。
PropertyEditor createPropertyEditor(Object object)：创建属性编辑器实例。
```
