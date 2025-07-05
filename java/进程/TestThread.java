
public class TestThread {
  public static void main(String[] args) {
      // 启动线程
      Thread thread = new Thread(() -> System.out.println("Thread is running!"));
      thread.start();

      // 让当前线程暂停一段时间
      try {
          Thread.sleep(1000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

      // 等待另外一个线程执行完毕后，再继续执行
      try {
          thread.join();
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

      // 中断一个线程
      thread.interrupt();

      // 判断线程是否处于活动状态
      System.out.println(thread.isAlive());

      // 让当前线程让出CPU资源
      Thread.yield();

      // 设置线程的优先级
      thread.setPriority(Thread.MAX_PRIORITY);
  }
}
