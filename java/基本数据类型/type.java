// 定义整数类型
byte b = 127;
short s = 32767;
int i = 2147483647;
long l = 9223372036854775807L;

// 定义浮点类型
float f = 3.4e38f;
double d = 1.7e308;

// 定义字符类型
char c = 'A';

// 定义布尔类型
boolean bl = true;

// 强制类型转换
public class Test {
    
  public static void main(String[] args) {
      double b = 2.5;
      int a = (int) b;
      System.out.println(a); // 显式类型转换，会将数字精度降低，导致输出的值是2。
  }
  
}
