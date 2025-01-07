public class Student {
  public String name = "Tom";
  public static int count = 0;

  public Student() {
    count++;
  }

  public static void main(String[] args) {
    Student s1 = new Student();
    Student s2 = new Student();

    System.out.println("Student count: " + Student.count); // 2 count变量是static修饰符修饰的，属于所有对象共同拥有的值，所以代码中是对同一个变量触发了两次的count++操作。
  }
}

// 所有的 Student 实例都可以共享这个静态成员变量 count
String studentcount = Student.count;

// 对象属性访问机制，对象属性的访问机制需要通过先new一个对象，然后再去通过对象来访问
Student student = new Student();//这里多了一步new
String studentName = student.name;
