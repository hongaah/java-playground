# 字符流

Java中的字符流也称为字符输入/输出流，是把字符数据读入程序或者将字符数据写出程序的流。字符流以字符为单位读取数据，而不是以字节为单位，因此可以更有效地处理文本文件。字符流基于字符集，因此可以以更高效的编码方式来处理文本，从而提高性能。 Java 中提供了两个基本的字符流类：Reader 和 Writer，它们分别用于读取和写入数据。比如，FileReader 用于从文件中读取数据，而 FileWriter 用于将数据写入文件中。

## 常见的字符流有哪些

InputStreamReader：从字节流转换为字符流。
BufferedReader：字符输入流，使用缓冲区。
CharArrayReader：从字符数组中读取数据。
StringReader：从字符串中读取数据。
FileReader：从文件中读取数据。
OutputStreamWriter：将字符流转换为字节流。
BufferedWriter：字符输出流，使用缓冲区。
CharArrayWriter：向字符数组中写入数据。
StringWriter：向字符串中写入数据。
FileWriter：将数据写入文件中。

## InputStreamReader 和 OutputStreamWriter

[StreamReaderWriterDemo](./StreamReaderWriterDemo.java)

## BufferedReader 和 BufferedWriter

读取文件input.txt中的内容，并将其内容输出到output.txt文件中。BufferedReader和BufferedWriter分别是字符输入流和字符输出流的缓冲流，能够实现更高效的读写操作。
[BufferedReaderWriterDemo](./BufferedReaderWriterDemo.java)

## CharArrayReader 和 CharArrayWriter

使用 try-with-resource 语句来实现从字符数组 charArray 中读取内容，并将内容写入到另一个字符数组 newCharArray 中，其中 CharArrayReader 和 CharArrayWriter 都实现了 AutoCloseable 接口，在 try 语句执行完毕时，JVM会自动调用 CharArrayReader 的 close() 方法和 CharArrayWriter 的 close() 方法来释放资源。

[CharArrayReaderWriterDemo](./CharArrayReaderWriterDemo.java)

## StringReader 和 StringWriter

使用 try-with-resource 语句来实现从字符串 str 中读取内容，并将内容追加到另一个字符串 builder 中，其中 StringReader 和 StringWriter 都实现了 AutoCloseable 接口，在 try 语句执行完毕时，JVM 会自动调用 StringReader 的 close() 方法和 StringWriter 的 close() 方法来释放资源。

[StringReaderWriterDemo](./StringReaderWriterDemo.java)

## FileReader和FileWriter

使用 try-with-resource 语句来实现从文件 src.txt 中读取内容，并将内容写入到文件 dest.txt 中，其中 FileReader 和 FileWriter 都实现了 AutoCloseable 接口，在 try 语句执行完毕时，JVM 会自动调用 FileReader 的 close() 方法和 FileWriter 的 close() 方法来释放资源。

[FileReaderWriterDemo](./FileReaderWriterDemo.java)

## 如何检测字符流的结束标志？

字符流的结束标志通常是 -1，当读取到 -1 时，表示字符流已经读取完毕。例如，InputStreamReader 类的 read() 方法返回的是 int 类型，当成功读取一个字符时，返回的是字符的 ASCII 值，而当读取到文件末尾时，返回 -1。

```java
if (inputStreamReader.read() == -1) {
  // 字符流已结束
}
```
