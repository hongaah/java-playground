import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassReflectDemo {

    static class Person {
        String name;
        int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void sayHello() {
            System.out.println("你好，我是" + this.name + ",今年" + this.age + "岁");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 获取类的 Class 对象
        Class clazz = Person.class;
        // 根据 Class 对象获取构造函数
        Constructor c = clazz.getConstructor(String.class, int.class);
        // 根据构造函数创建实例
        Object obj = c.newInstance("张三", 20);
        // 设置实例的属性
        Field f = clazz.getDeclaredField("name");
        // 设置实例的属性值,并将私有属性设置为可访问
        f.setAccessible(true);
        f.set(obj, "李四");

        // 获取实例的方法
        Method m = clazz.getDeclaredMethod("sayHello");
        // 将私有方法设置为可访问
        m.setAccessible(true);
        m.invoke(obj);
    }
}
