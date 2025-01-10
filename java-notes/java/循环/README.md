循环：for, while, do while
中止循环：break, continue

```java
// for
int sum = 0;
for(int i=1;i<=100;i++){
  if (i == 5) {
      break;
  }
  if (i == 4) {
      continue;
  }
  sum = sum + i;
}
System.out.println("sum = " + sum);

// while
int i = 1;
int sum = 0;
while (i <= 100) {
    sum = sum + i;
    i++;
}
System.out.println(sum);

// do while
int i = 1;
int sum = 0;
do {
    sum = sum + i;
    i++;
} while (i <= 100);
System.out.println(sum);
```