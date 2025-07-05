public class Test {

  private static String[][] students = {
    {"张三", "18", "男"},
    {"李四", "20", "女"},
    {"王五", "19", "男"},
    {"赵六", "17", "女"},
    {"赵七", "22", "男"}
  };

  public static void main(String[] args) {
    for (int i = 0; i < students.length; i++) {
      System.out.println("姓名：" + students[i][0] + "，年龄：" + students[i][1] + "，性别：" + students[i][2]);
    }
  }
}