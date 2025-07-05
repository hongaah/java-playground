# Future

Java的Future是一种用于处理异步任务的模式，它允许可以让程序员把耗时的任务从主线程中解耦，从而提高程序的响应能力和吞吐量。 通常来说，Future可以被用于以下几种情况：

处理异步网络请求：当一个网络请求发出时，Future可以把它放到另一台机器上运行，而不用等待它完成，然后再去处理其它的任务。

实现多线程：Future可以把一个任务分解成多个任务，并将它们放到多个线程上运行，从而提高程序的执行效率。

处理复杂的任务：当一个任务非常复杂时，可以使用Future把它分解成更小的任务，并将它们放到多台机器上运行，从而提高程序的执行效率。

处理大型数据集：当处理大型数据集时，可以使用Future把它分解成更小的任务，并将它们放到多台机器上运行，从而提高程序的执行效率。

## 如何使用Future

Future 是一个接口，不能直接使用，必须要有一个实现了 Future 接口的类（如FutureTask）才能使用。FutureTask 是一个实现了 Future 接口的类，它实现了 Runnable 接口，可以把它当作一个任务并将其放到线程池中执行。

🌰: ./FutureExample.java

## FutureTask 常用方法

FutureTask 接口提供了一组方法来操作异步任务，它们包括：

- boolean cancel(boolean mayInterruptIfRunning) : 用于取消任务。
- V get() : 用于获取任务的结果。
- boolean isCancelled(): 检查任务是否已经被取消。
- boolean isDone(): 检查任务是否已经完成。
- void run(): 启动任务。

🌰: ./FutureDemo.java

## 在使用 FutureTask 的时候需要注意些什么？

- 当使用 FutureTask 时，应该注意检查任务是否已经取消，如果取消就不要继续执行任务。如果 FutureTask 已经取消，应该尽快抛出CancellationException 异常，来提示程序。
- 使用 FutureTask.get()方法的时候要注意，因为它会阻塞调用线程，会影响程序性能。