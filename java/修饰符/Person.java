public class Person {
  //public成员变量可以被任何类访问
  public String name;

  //protected成员变量可以被同一个包中的类以及所有子类访问
  protected int age;

  //private成员变量只能被同一个类中的方法访问
  private double salary;

  //public成员方法可以被任何类调用
  public void getInfo() {
    System.out.println("Name: "+name+" Age: "+age+" Salary: "+salary);
  }

  //protected成员方法可以被同一个包中的类以及所有子类调用
  protected void setAge(int a) {
    age = a;
  }

  //private成员方法只能被同一个类中的方法调用
  private void setSalary(double s) {
    salary = s;
  }
}

public class Test {
  public static void main(String args[]) {
    Person p = new Person();
    p.name = "John";
    p.setAge(20);
    //这里的setSalary是私有方法，外部类无法调用
    p.setSalary(5000.0);
    p.getInfo();
  }
}

public class Test2 extends Person {
  public static void main(String args[]) {
    Test2 t2 = new Test2();
    t2.name = "Tom";
    t2.setAge(25);
    //t2.setSalary(10000.0); //不能调用
    t2.getInfo();
  }
}
