package concurrency.futures;

import concurrency.Task;
import concurrency.Threading;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTaskExample extends Threading {
  public static void main(String[] args) {
    Task task = new Task("task-0");

    // using future task
    FutureTask<String> futureTask = new FutureTask<>(task);

    try {
      println("Calling a task...");
      futureTask.run();
      println(futureTask.get(5, TimeUnit.SECONDS));
    } catch (Exception e) {
      e.printStackTrace();
    }

    // using executor
    ExecutorService executorService = fixedPool(5);
    FutureTask<String> newTask = new FutureTask<>(task);
    executorService.execute(newTask);

    try {
      println("Waiting for execution at most 5 sec...");
      println(newTask.get(5, TimeUnit.SECONDS));
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      e.printStackTrace();
    } finally {
      executorService.shutdown();
    }
  }
}
