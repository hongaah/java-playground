
// 封装
public class Student {
  private String name;
  private String gender;
  private int age;

  public Student(String name,String gender,int age) {
    this.name = name;
    this.gender = gender;
    this.age = age;
  }

  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return this.name;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public String getGender() {
    return this.gender;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public int getAge() {
    return this.age;
  }
}

// 继承
// Student类是一个父类，它定义了三个属性name、gender、age，以及对这三个属性的get/set方法。GraduateStudent类继承自Student类，它增加了一个属性major，并提供了相应的get/set方法。因此，GraduateStudent类具有Student类的所有属性和行为，并增加了一个新的属性major。
public class GraduateStudent extends Student {
  private String major;

  public GraduateStudent(String name,String gender,int age,String major) {
    super(name,gender,age);
    this.major = major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public String getMajor() {
    return this.major;
  }
}
