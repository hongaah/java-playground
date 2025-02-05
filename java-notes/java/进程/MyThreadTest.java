
public class MyThreadTest {
  public static void main(String[] args) {
      // Thread 的 start 方法是启动一个线程的方法，它调用了native start()方法，它会调用线程的run()方法，而run()方法是由用户实现的，它定义了该线程要做的事情。start()方法不能被重复调用，否则会抛出IllegalThreadStateException异常。
      MyThread myThread = new MyThread();
      myThread.start();
  }
}

class MyThread extends Thread {
  // 继承 Thread 类的方式，如果要启动多线程，需要创建 Thread 类的子类，并重写 run 方法，然后创建子类对象并调用 start 方法
  @Override
  public void run(){
    System.out.println("MyThread running");
  }
}
