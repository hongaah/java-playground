import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCallableTest {
  public static void main(String[] args) throws Exception {
      MyCallable task = new MyCallable();
      FutureTask<String> futureTask = new FutureTask<>(task);
      Thread thread = new Thread(futureTask);
      thread.start();
      String result = futureTask.get();
      System.out.println(result);
  }
}

class MyCallable implements Callable<String> {
  @Override
  public String call() throws Exception {
      // 进行任务处理，并返回处理结果
      String result = "hello";
      return result;
  }
}
