public class User {

  private String name;
  private String tel;

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getTel() {
      return tel;
  }

  public void setTel(String tel) {
      this.tel = tel;
  }

  private class innerUser {
      private Integer id;
      private String address;

      public Integer getId() {
          return id;
      }

      public void setId(Integer id) {
          this.id = id;
      }

      public String getAddress() {
          return address;
      }

      public void setAddress(String address) {
          this.address = address;
      }
  }

  public static void main(String[] args) {
      User user = new User();
      user.setName("name");
      user.setTel("189127678888");
      User.innerUser innerUser = user.new innerUser();
      innerUser.setAddress("shenzhen");
      innerUser.setId(1);
      System.out.println(user.getName());
      System.out.println(user.getTel());
      System.out.println(innerUser.getAddress());
      System.out.println(innerUser.getId());
      // 下面这一行编译会有报错，内部类的方法使用必须通过具体内部类的实例去调用，不能写成以下方式
      // System.out.println(user.innerUser.getAddress());
      System.out.println(innerUser.getAddress());
  }
}
