运算符

算术运算符：+、-、*、/、%
关系运算符：>, <, >=, <=, ==, !=
逻辑运算符：&&、||、!
赋值运算符：=、+=、-=、*=、/=、%=
位运算符：&、|、^、~、<<、>>
条件运算符：?:
instanceof运算符：instanceof

```java
int a = 10; 
int b = 5; 
int c = a + b; // c = 15
int d = a - b; // d = 5
int e = a * b; // e = 50
int f = a / b; // f = 2
int g = a % b; // g = 0

boolean c = a > b; // c = true
boolean d = a < b; // d = false
boolean e = a >= b; // e = true
boolean f = a <= b; // f = false
boolean g = a == b; // g = false
boolean h = a != b; // h = true

boolean a = true;
boolean b = false;
boolean c = a && b; // c = false
boolean d = a || b; // d = true
boolean e = !a;     // e = false

int a = 10; 
int b = 5; 
a = b;     // a = 5
a += b;    // a = 10
a -= b;    // a = 5
a *= b;    // a = 25
a /= b;    // a = 5
a %= b;    // a = 0

int a = 10; 
int b = 5; 
int c = a & b; // c = 0
int d = a | b; // d = 15
int e = a ^ b; // e = 15
int f = ~a;    // f = -11
int g = a << 2; // g = 40
int h = a >> 2; // h = 2

int a = 10; 
int b = 5; 
int c = (a > b) ? a : b; // c = 10

// instanceof运算符用于完成类型比较
String str = "Hello World";
boolean bool = str instanceof String; // bool = true

```