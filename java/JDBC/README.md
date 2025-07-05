# JDBC

JDBC（Java Database Connectivity）是一种用于在 Java 应用程序和数据库之间通信的 API。它是Java SE平台的一部分，提供了一种标准的Java方法来访问各种类型的数据库。

[JDBC数据库驱动的下载、安装与连接](https://blog.csdn.net/pan_junbiao/article/details/86626741)：[jdbc](https://downloads.mysql.com/archives/c-j/)

使用JDBC，可以轻松地从Java应用程序中连接和操作关系型数据库。Java应用程序可以执行各种操作，如查询、插入、更新和删除数据。此外，JDBC还提供了事务处理和元数据访问等高级功能。

JDBC API提供了一套标准的接口和类，以帮助开发人员使用Java与数据库进行通信。这些类和接口包括：

DriverManager类：该类为应用程序提供了一个标准的接口，以便连接到一个或多个数据库。它还提供了一组静态方法，以注册和注销驱动程序。
Connection接口：该接口表示与数据库的连接。可以使用此接口执行各种数据库操作。
Statement接口：该接口表示可以执行在数据库中执行的SQL语句。可以使用此接口执行各种操作，如查询、插入、更新和删除数据。
ResultSet接口：该接口表示查询结果集。可使用此接口从数据库中检索查询结果。
PreparedStatement接口：该接口继承了Statement接口，并提供了更高效和安全的SQL语句执行功能。使用此接口可以预编译SQL语句。
JDBC的优点是它是标准的、跨平台的和可靠的。它支持连接各种类型的数据库，并且易于学习和使用。实际上，大多数使用Java的企业应用程序都使用JDBC来与数据库进行通信。