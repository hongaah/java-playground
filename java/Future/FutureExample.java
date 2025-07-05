import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            int result = 0;
            for (int i = 0; i < 100; i++) {
                result += i;
            }
            return result;
        });
        // 将计算求和的任务交给了 FutureTask 类去处理，在没有获取到结果之前，我们调用 FutureTask 的 get 函数是不会返回任何内容的。
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("计算结果为：" + futureTask.get());
    }
}
