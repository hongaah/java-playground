# 字节流

字节流（Byte Stream）是 Java 中的一种流，它是处理二进制数据的最基本的流，可以处理任何类型的数据，例如字符串、图像等。字节流的特点是把数据看成一个个字节，它们是无类型的，可以处理任何类型的数据。

## 常见的字节流类有哪些？

InputStream：这个是字节流的抽象类，提供了某些字节流操作的基本实现，比如读取、关闭流等。
OutputStream：同样也是字节流抽象类，提供字节流操作的基本实现，比如写入、关闭流等。
FileInputStream：允许应用程序以字节的方式从文件中读取数据。
FileOutputStream：允许应用程序以字节的方式向文件写入数据。
ByteArrayInputStream：允许应用程序从一个字节数组中读取数据。
ByteArrayOutputStream：允许应用程序以字节的方式向字节数组中写入数据。
DataInputStream：允许应用程序从输入流中读取基本的Java数据类型。
DataOutputStream：允许应用程序以字节的方式向输出流中写入基本的Java数据类型。
FilterInputStream：抽象类，从另一个输入流中读取数据。
FilterOutputStream：抽象类，向另一个输出流中写入数据。
ObjectInputStream：允许应用程序从输入流中读取Java对象。
ObjectOutputStream：允许应用程序以字节的方式向输出流中写入Java对象。
PipedInputStream：允许应用程序从管道输入流中读取数据。
PipedOutputStream：允许应用程序以字节的方式向管道输出流中写入数据。

## FileInputStream 和 FileOutputStream

```java
// 使用 FileInputStream 和 FileOutputStream 实现了文件的复制操作
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamDemo {
  public static void main(String[] args) {
    try (FileInputStream fis = new FileInputStream("D:/file/example.txt"); 
        FileOutputStream fos = new FileOutputStream("D:/file/example_copy.txt")) {

      // 创建一个字节数组，用于存储源文件的内容，并使用 FileInputStream 的 read() 方法将源文件的内容读取到该字节数组中，最后使用 FileOutputStream 的 write() 方法将该字节数组中的内容写入到目标文件中。
      int len;
      byte[] buf = new byte[1024];
      while ((len = fis.read(buf)) != -1) {
        fos.write(buf, 0, len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
}
```

## ByteArrayInputStream 和 ByteArrayOutputStream

```java
// 使用了 ByteArrayInputStream 和 ByteArrayOutputStream 来实现字符串大小写转换的功能
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream; 

public class ByteArrayDemo { 

  public static void main(String[] args) {
    String str = "This is a just a test"; 

    // ByteArrayInputStream 从字符串的字节数组中读取数据，而 ByteArrayOutputStream 通过写入 Character.toUpperCase 方法将小写字母转换为大写，并将结果写入 ByteArrayOutputStream中。最后通过调用 baos.toString() 方法将转换后的字符串打印出来。
    try(ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
      ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      int c = 0;
      while((c=bais.read()) != -1) {
        baos.write(Character.toUpperCase(c)); 
      }
      System.out.println(baos);
    } catch (Exception e) { 
      e.printStackTrace(); 
    }
  }
}
```

## DataInputStream 和 DataOutputStream

```java
import java.io.*;

public class DataStreamDemo {
  public static void main(String[] args) {
    String filename = "data.txt";
    try (FileOutputStream fos = new FileOutputStream(filename);
          DataOutputStream dos = new DataOutputStream(fos);
          FileInputStream fis = new FileInputStream(filename);
          DataInputStream dis = new DataInputStream(fis))
    {
        // 写入一些字符
        dos.writeUTF("Hello World");
        // 写入一些整型数据
        dos.writeInt(123);
        dos.writeFloat(123.45f);
        dos.writeBoolean(true);

        // 读取字符
        String str = dis.readUTF();
        // 读取整型数据
        int i = dis.readInt();
        float f = dis.readFloat();
        boolean b = dis.readBoolean();
        // 打印读取的数据
        System.out.println("str = " + str);
        System.out.println("i = " + i);
        System.out.println("f = " + f);
        System.out.println("b = " + b);
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}
```

## ObjectInputStream 和 ObjectOutputStream

```java
// 使用 ObjectOutputStream 将 Person 对象序列化到文件 data.obj 中，并使用 ObjectInputStream 从 data.obj 文件反序列化出Person对象，并打印出Person对象的信息

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializationDemo {

  static String OBJECT_FILENAME = "data.obj";
  
  public static void main(String[] args) {
    // 将对象序列化到文件
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(OBJECT_FILENAME))) {
      oos.writeObject(new Person("idea", 192));
    } catch (Exception e) {
      e.printStackTrace();
    }

    // 从文件反序列化出对象
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(OBJECT_FILENAME))) {
      Person person = (Person) ois.readObject();
      System.out.println(person);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

// Person 类实现了 Serializable 接口，以支持序列化和反序列化，否则会抛出异常  
  static class Person implements java.io.Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return "Person [name=" + name + ", age=" + age + "]";
    }
  }
}
```

## PipedInputStream 和 PipedOutputStream

```java
// 使用了 PipedInputStream 和 PipedOutputStream 来实现数据的管道传输，使用 try-with-resources 去实现资源的自动关闭。
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedInputStreamExample {
  public static void main(String[] args) throws IOException {
    try (PipedInputStream pipedInputStream = new PipedInputStream();
          PipedOutputStream pipedOutputStream = new PipedOutputStream()) {
      // 将 pipedOutputStream 与 pipedInputStream 连接起来 
      pipedInputStream.connect(pipedOutputStream);

      // 定义了一个 byte 数组，通过 pipedOutputStream.write(bytes) 将byte数组中的内容写入管道
      byte[] bytes = {11, 21, 3, 40, 5};
      pipedOutputStream.write(bytes);

      // 最后使用 pipedInputStream.read() 从管道中读取数据，并将读取的数据打印出来。
      int data = pipedInputStream.read();
      while (data != -1) {
        System.out.print(data + " ");
        data = pipedInputStream.read();
      }
    }
  }
}

```

## IO 流的关闭

看了上边的几段代码案例，你应该会明显发现，很多的 IO 流代码案例中，都需要执行一部关闭流操作的步骤。这是因为 Java 的 IO 流会占用系统资源，如果不关闭，可能会造成系统资源的浪费，影响程序的性能。此外，如果不关闭 IO 流，可能会导致文件无法被写入或读取，从而影响程序的正常运行。

### Java中常见的关闭IO流操作有哪些？

- 使用try-with-resources方法关闭资源：try-with-resources语句可以优雅地关闭IO流，它可以在try语句块结束时自动关闭资源，而不需要手动关闭；
- 使用close()方法关闭资源：close()方法是用来关闭输入流或输出流的方法，它处理的是一次性的资源关闭，其具体的实现是将资源的引用设置为null；
- 使用flush()方法清空缓冲区：flush()方法是用来清空输出缓冲区的方法，它会将缓冲区中的内容刷新到输出流中，使得缓冲区清空，这样就可以避免程序出现异常。

### 如何检测字节流的结束标志？

可以使用 InputStream 的 available() 方法来检测字节流的结束标志，当 available() 返回 0 时，表示字节流已经结束。

```java
if (inputStream.available() == 0) {
  //字节流已结束
}
```
