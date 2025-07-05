# 包装类

Java中的包装类主要用于为基本数据类型提供引用类型的支持，使得开发人员可以把基本数据类型当作对象来处理，例如将基本类型放入容器中、作为函数的参数传递等。

- 使用包装类型，可以将基本类型转换成对象，这样就可以使用对象的方法和特性来处理基本类型了。
- 包装类型提供的方法比基本类型更加丰富，比如可以使用Integer.parseInt()方法将字符串转换成基本类型，使用Integer.toString()方法将基本类型转换成字符串。
- 包装类可以把基本类型转换成对象，例如可以把基本类型传入ArrayList对象中。

## Java中常用的包装类

Byte (byte)：表示一个字节，取值范围为-128~127。
Short (short)：表示一个短整型，取值范围为-32768~32767。
Integer (int)：表示一个整型，取值范围为-2147483648~2147483647。
Long (long)：表示一个长整型，取值范围为-9223372036854775808~9223372036854775807。
Float (float)：表示单精度浮点数，浮点数的精确度为7位小数，取值范围为1.4e-45~3.4028235e38。
Double (double)：表示双精度浮点数，浮点数的精确度为15位小数，取值范围为4.9e-324~1.7976931348623157e308。
Boolean (boolean)：表示布尔值，取值范围为true和false。
Character (char)：表示字符，取值范围为0~65535。

### Byte

Byte 对象是 Java 中的 8 位有符号整数对象，它的范围是从 -128 到 127。它可以用于存储字节型数据，并且可以用于作为字节形式的数据，如图像、文件、音频等的处理和传输。它还可以用于操作和比较经过编码的文本，例如 UTF-8 和 ASCII。

```java
//创建Byte对象 加 (byte) 是为了避免由于编译器的类型推断规则导致的隐式类型提升 不加默认是就int
Byte b = new Byte((byte)127); 
System.out.println("Byte object: "+ b);

//获取byte值 
byte bValue = b.byteValue(); 
System.out.println("byte value: "+ bValue);
```

### Short

Short 对象是 Java 中的 16 位有符号整数对象，它的范围是从 -32768 到 32767。它主要用于存储短整型数据。

```java
//创建Short对象 
Short s = new Short((short)1000); 
System.out.println("Short object: "+s);

//获取short值 
short sValue = s.shortValue(); 
System.out.println("short value: "+sValue);
```

### Integer

Integer 对象是Java中的 32 位有符号整数对象，它的范围是从 -2147483648 到 2147483647。它主要用于存储整型数据。

```java
//创建Integer对象 
Integer i = new Integer(10000); 
System.out.println("Integer object: "+i);

//获取int值 
int iValue = i.intValue(); 
System.out.println("int value: "+iValue);
```

### Long

Long 对象是 Java 中的 64 位有符号整数对象，它的范围是从 -9223372036854775808 到 9223372036854775807。它主要用于存储长整型数据。

```java
//创建Long对象 
Long l = new Long(1000000000000L); 
System.out.println("Long object: "+l);

//获取long值 
long lValue = l.longValue(); 
System.out.println("long value: "+lValue);

```

### Float

Float 对象是 Java 中的 32 位单精度浮点数对象，它的范围是从 -3.4E+38 到 3.4E+38 。它主要用于存储单精度浮点数据。

```java
//创建Float对象 
Float f = new Float(3.1415926); 
System.out.println("Float object: "+f);

//获取float值
float fValue = f.floatValue(); 
System.out.println("float value: "+fValue);
```

### Double

Double 对象是 Java 中的 64 位双精度浮点数对象，它的范围是从 -1.7E+308 到 1.7E+308。它主要用于存储双精度浮点数据。

```java
//创建Double对象 
Double d = new Double(3.1415926535); 
System.out.println("Double object: "+d);

//获取double值
double dValue = d.doubleValue(); 
System.out.println("double value: "+dValue);
```

### Boolean

Boolean 对象是 Java 中的布尔对象，它可以存储布尔值，即 true 和 false。它可以用于处理布尔类型的数据，例如判断表达式或测试条件。

```java
//创建 Boolean 对象 
Boolean bool = new Boolean(true); 
System.out.println("Boolean object: "+bool);
//获取 boolean 值 
boolean boolValue = bool.booleanValue(); 
System.out.println("boolean value: "+boolValue);
```

### Character

Character 对象是 Java 中的字符对象，它可以存储 Unicode 字符，介于 \u0000 和 \uffff 之间，其中 \u0000 表示 null 字符。它可以用于处理字符类型的数据，例如比较字符、转换大小写等。

```java
//创建 Character 对象
Character c = new Character('a'); 
System.out.println("Character object: "+c);

//获取 char 值
char cValue = c.charValue();
System.out.println("char value: "+cValue);
```

## 拆箱和装箱

拆箱是指将包装类对象转换为基本类型数据的操作。此操作可以通过调用基本类型的值来实现，如intValue(),doubleValue() 等。
装箱是指将基本类型数据转换为包装类对象的操作，它可以通过调用包装类的静态方法valueOf()来实现。

```java

byte b = Byte.valueOf(str); // 把字符串转换为byte
Byte bb = Byte.valueOf(b); // 把byte转换为Byte

short s = Short.valueOf(str); // 把字符串转换为short
Short ss = Short.valueOf(s); // 把short转换为Short

int i = Integer.valueOf(str); // 把字符串转换为int
Integer ii = Integer.valueOf(i); // 把int转换为Integer

long l = Long.valueOf(str); // 把字符串转换为long
Long ll = Long.valueOf(l); // 把long转换为Long

float f = Float.valueOf(str); // 把字符串转换为float
Float ff = Float.valueOf(f); // 把float转换为Float

double d = Double.valueOf(str); // 把字符串转换为double
Double dd = Double.valueOf(d); // 把double转换为Double

boolean b = Boolean.valueOf(str); // 把字符串转换为boolean
Boolean bb = Boolean.valueOf(b); // 把boolean转换为Boolean

char c = Character.valueOf(str); // 把字符串转换为char
Character cc = Character.valueOf(c); // 把char转换为Character

```
