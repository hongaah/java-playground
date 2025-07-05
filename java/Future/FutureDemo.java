import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureDemo {
    public static void main(String[] args) throws Exception {

        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("this is start");
                Thread.sleep(1000);
                System.out.println("this is end");
                return "idea";
            }
        });

        // 新建一个FutureTask任务，然后将其交给一个新的线程去执行，当线程开始执行任务时，会先检查该任务是否被取消，如果没有被取消，则在任务执行完成后，调用futureTask的get方法就可以获取任务的执行结果。
        Thread thread = new Thread(futureTask);
        thread.start();

        if (futureTask.isCancelled()) {
          System.out.println("任务被中断了");
        }

        Thread.sleep(2000);

        if (futureTask.isDone()) {
          String result = futureTask.get();
          System.out.println(result);
        }
    }
}
