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

### Date类相关代码案例

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

// 使用setTime()方法设置一个时间点，1970年1月1日08:00:00 GMT
date1.setTime(28800000);
// 使用before()方法比较两个时间点
boolean beforeResult = date1.before(date2);
System.out.println("设置的时间点在1970年1月1日之前：" + beforeResult);

// 使用after()方法比较两个时间点
boolean afterResult = date1.after(date2);
System.out.println("设置的时间点在1970年1月1日之后：" + afterResult);

// 使用equals()方法比较两个时间点
boolean equalResult = date1.equals(date2);
System.out.println("设置的时间点与当前时间相等：" + equalResult);

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

### Calendar类介绍

Java中的Calendar类是一个抽象类，用于操作日期和时间。它是对Date类的封装，提供了更加丰富的操作方法。Calendar类的主要作用是计算日期和时间之间的差值，并提供了一些方法得到年、月、日、时、分等时间信息。

Calendar类提供了很多有用的API，以下是其中一些常用的API：

```java
package com.sise.lession93;

import java.util.*;

public class CalendarExample {
    public static void main(String[] args) {
        // 创建一个表示当前时间的Calendar对象
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(); // 创建一个Date对象

        // 输出年份、月份和日期
        System.out.println("年份：" + calendar.get(Calendar.YEAR));
        System.out.println("月份：" + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("日期：" + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("时，24小时制：" + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("分：" + calendar.get(Calendar.MINUTE));
        System.out.println("秒：" + calendar.get(Calendar.SECOND));

        // 设置月份为10，日期为15
        calendar.set(Calendar.MONTH, 9); // 月份从0开始计算，所以9表示10月
        calendar.set(Calendar.DAY_OF_MONTH, 15);

        // 输出修改后的日期
        System.out.println("修改后的日期：" + calendar.getTime());
        
        // 对日期进行加减
        calendar.add(Calendar.DAY_OF_MONTH, 3); // 加3天
        System.out.println("加3天后的日期：" + calendar.getTime());
        calendar.add(Calendar.MONTH, -2); // 减2个月
        System.out.println("减2个月后的日期：" + calendar.getTime());

        if (calendar.before(date)) {
            System.out.println("今天在该日期之前");
        } else {
            System.out.println("今天在该日期之后");
        }
    }
}

```

### SimpleDateFormat类的示例代码

SimpleDateFormat 是 Java 中用于日期格式化和解析的类。它允许定义日期格式以将日期对象转换为字符串并将字符串转换回日期对象。

```java
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {
    public static void main(String[] args) throws Exception {
        String dateString = "2021-01-31";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date date = format.parse(dateString);
        System.out.println("Date object: " + date.toString());

        String formattedDate = format.format(date);
        System.out.println("Formatted date string: " + formattedDate);
    }
}

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

// now()：静态方法，用于获取当前系统日期。
LocalDateTime now = LocalDateTime.now();
System.out.println("Current DateTime: " + now); 

// of(int year, int month, int dayOfMonth)：静态方法，用于创建指定日期的LocalDate对象。
LocalDateTime specificDate = LocalDateTime.of(2021, Month.JANUARY, 1, 10, 30);
System.out.println("Specific DateTime: " + specificDate);

// getYear()、getMonthValue()和getDayOfMonth()：获取日期的年、月、日。
int year = today.getYear();
int month = today.getMonthValue();
int dayOfMonth = today.getDayOfMonth();

// 使用 LocalDateTime 对日期和时间进行加减
LocalDateTime today = LocalDateTime.now();

// plusDays()、plusMonths()和plusYears()：将日期加上指定的天数、月数、年数。
LocalDate tomorrow = today.plusDays(1);
LocalDate thisMonth = today.plusMonths(0);
LocalDate nextYear = today.plusYears(1);

// minusDays()、minusMonths()和minusYears()：将日期减去指定的天数、月数、年数。
LocalDate yesterday = today.minusDays(1);
LocalDate lastMonth = today.minusMonths(1);
LocalDate lastYear = today.minusYears(1);

// isBefore()和isAfter()：用于比较当前日期是否在指定日期之前或之后。
LocalDate date1 = LocalDate.of(2022, 10, 1);
LocalDate date2 = LocalDate.of(2022, 10, 2);
boolean isBefore = date1.isBefore(date2); // 返回trueboolean isAfter = date1.isAfter(date2); // 返回false

// format()：将日期格式化为指定格式的字符串。
String formattedDate = today.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")); // 2022/10/03
```

## 使用技巧

在使用Java中的日期类时，有以下一些技巧可以提高开发效率和避免常见错误：

使用 LocalDate 而不是 Date：Date 是Java早期版本中的日期类，不仅在处理时区和日期格式方面存在问题，而且通常需要使用 SimpleDateFormat 类进行日期格式化和解析。相反，Java 8 引入了新的日期和时间API，其中包括 LocalDate 类。LocalDate 类提供了一种简单且线程安全的方式来表示日期，它还可以轻松进行格式化和解析，而不需要使用其他类。

使用预定义格式解析和格式化日期字符串：在使用 SimpleDateFormat 进行格式化和解析日期时，通常需要自己定义日期格式。这种方式容易出错且容易导致代码的可读性下降。Java 8 中新增了 DateTimeFormatter类，该类提供了预定义的日期格式以及自定义的格式化和解析。使用 DateTimeFormatter 类进行日期格式化和解析可以减少犯错的机会。

使用 Calendar 时要注意月份的索引从0开始：在使用 Calendar 类获取月份时，月份的索引从 0 开始，即 0 表示 1 月，1 表示 2 月，以此类推。这可能会导致混淆和错误，因此建议使用 LocalDate 代替。

使用 Period 和 Duration 进行日期和时间的计算：Period 和 Duration 类分别用于计算日期和时间之间的差异。这些类提供了易于使用且灵活的 API，可用于计算日期之间的差异（例如年、月和天）以及时间之间的差异（例如小时，分钟和秒）。

总结来说，使用 Java 中的日期类时，建议使用新的日期和时间类LocalDate，避免使用过时的Date和Calendar类。