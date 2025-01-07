数组可以给我们带来哪些好处？

方便索引，数组可以使用索引来定位元素，可以极大提高程序的效率。
内存占用少，数组存储的元素类型相同，因此可以节省内存空间。
数组的遍历更加方便，可以使用for循环来进行数组的遍历，可以很方便地实现数组中的每个元素。

```java
// 一维数组
int[] myArray = new int[5];

myArray[0] = 10;
myArray[1] = 20;
myArray[2] = 30;
myArray[3] = 40;
myArray[4] = 50;

int val = myArray[3];

// 二维数组
String[][] students = {
  {"张三", "18", "男"},
  {"李四", "20", "女"},
  {"王五", "19", "男"},
  {"赵六", "17", "女"},
  {"赵七", "22", "男"}
};

for (int i = 0; i < students.length; i++) {
  System.out.println("姓名：" + students[i][0] + "，年龄：" + students[i][1] + "，性别：" + students[i][2]);
}
```


