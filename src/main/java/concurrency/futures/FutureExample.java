package concurrency.futures;

import concurrency.Task;
import concurrency.Threading;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureExample extends Threading {
  public static void main(String[] args) {
    ExecutorService executorService = fixedPool(5);

    Future<String> results = executorService.submit(new Task("tasko"));

    try {
      println("Waiting for execution at most 5 sec...");
      println(results.get(5, TimeUnit.SECONDS));
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      e.printStackTrace();
    } finally {
      executorService.shutdown();
    }
  }
}
