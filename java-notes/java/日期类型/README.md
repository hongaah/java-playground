# 日期类型

日期类型是一种特殊的数据类型，用于存储日期和时间。Java中提供了多种日期类型，可以帮助我们处理日期和时间，并让我们能够实现日期和时间的计算。 Java中的日期类型可以分为两类：旧的日期类型和新的日期类型。

## 关于Java中的日期类使用，这里我总结了一些经验和大家分享：

- 优先使用 Java 8 的新日期/时间 API：java.time 包，它是早期的 java.util 包的替代品，更简单易用。
- 尽量避免使用过时的 java.util.Date 和 SimpleDateFormat 类，因为它们可能会导致严重的 bug，并且不支持时区。
- 使用 ISO 8601 格式（yyyy-MM-dd）来表示日期，以确保正确性。
- 尽可能地尝试使用线程安全的类，例如 java.time.LocalDateTime 和 java.time.LocalDate。
- 如果需要，可以使用 java.util.Calendar 类来表示日期，但需要谨慎处理，因为它不是线程安全的。

## 为什么 Java 8 的新日期/时间 API 比早期的 java.util 包更好？

Java 8 的新日期/时间 API 比早期的 java.util 包更好，因为它提供了更加简便、可读性更好的 API，并且支持时区，更加安全可靠。此外，它提供了用于计算、比较、格式化日期/时间的许多方法，以及用于将日期/时间转换为字符串的格式化方法，使得操作日期/时间变得更加容易。

比如，早期的 java.util 包中的 Date 类，只能处理时间戳，而不能处理时区，这可能会导致一些 bug，比如日期被误解释成另一个时区的时间。

而 Java 8 的新日期/时间 API 中的 LocalDateTime 类，支持时区，可以确保日期能够被正确解释。此外，java.util 包中的 SimpleDateFormat 类，仅支持一种日期格式，而 Java 8 的新日期/时间 API 中的 DateTimeFormatter 类，支持各种日期/时间格式，使得格式化操作更加简单。

## 旧的日期类型

旧的日期类型包括Date和Calendar，它们可以用于表示日期和时间。Date类是Java中最常用的日期类型，它可以让我们计算出任意日期之间的时间差。Calendar类可以让我们计算出任意日期之间的天数或月数。

Date类相关代码案例

```java
// 获取当前时间
Date date = new Date();
System.out.println(date);//输出的是当前时间
System.out.println(date.getTime());//输出的是当前时间戳
System.out.println(date.getDay());//输出的是当前属于星期几
System.out.println(date.getMonth());//输出的是当前是几月，注意jdk里面的月份是从0开始计算的
System.out.println(date.getYear());//输出的是当前的年，注意jdk里面的年是从1900年开始累积的，2023年输出的是123
System.out.println(date.getHours());//输出的是当前小时数
System.out.println(date.getMinutes());//输出的是当前分钟数
System.out.println(date.getSeconds());//输出的是当前秒数

// 获取指定时间
Calendar calendar = Calendar.getInstance();
calendar.set(2015, 11, 15);
Date date = calendar.getTime();

// 时间比较
Date date1 = new Date();
Date date2 = new Date();
if(date1.compareTo(date2) > 0) {
    //date1比date2晚
} else if(date1.compareTo(date2) == 0) {
    //date1和date2相等
} else {
    //date1比date2早
}

// 时间转换
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String dateStr = sdf.format(date);

// 时间添加
Date date = new Date();
Calendar calendar = Calendar.getInstance();
calendar.setTime(date);
calendar.add(Calendar.MONTH, 1);
date = calendar.getTime();

// 获取当前时区
TimeZone timeZone = TimeZone.getDefault();
System.out.println(timeZone.getDisplayName());

```

## 新的日期类型

另一类新的日期类型是Java 8推出的新特性，称为新的日期和时间API。它提供了一种更为简单的方式来处理日期和时间，允许开发人员更轻松地实现日期和时间的计算。新的日期和时间API包括LocalDate、LocalTime和LocalDateTime等类，它们可以让我们处理日期和时间，而无需使用Date和Calendar类。

```java
// 在 Java 8 中，我们可以使用 LocalDateTime 来比较两个日期的大小，以确定一个日期是否在另一个日期之前或之后
LocalDateTime firstDateTime = LocalDateTime.of(2021, Month.JANUARY, 1, 10, 30);
LocalDateTime secondDateTime = LocalDateTime.of(2021, Month.JANUARY, 2, 10, 30);
if (firstDateTime.isBefore(secondDateTime)) {
  System.out.println("firstDateTime is before secondDateTime");
}

// 使用 LocalDateTime 获取当前时间
LocalDateTime now = LocalDateTime.now();
System.out.println("Current DateTime: " + now); 

// 使用 LocalDateTime 获取指定日期时间
LocalDateTime specificDate = LocalDateTime.of(2021, Month.JANUARY, 1, 10, 30);
System.out.println("Specific DateTime: " + specificDate);

// 使用 LocalDateTime 对日期和时间进行加减
LocalDateTime dateTime = LocalDateTime.now();
// 增加一天
LocalDateTime dateTimePlus = dateTime.plusDays(1);
System.out.println("Plus one day: " + dateTimePlus);
// 减少一个小时
LocalDateTime dateTimeMinus = dateTime.minusHours(1);
System.out.println("Minus one hour: " + dateTimeMinus);
```
