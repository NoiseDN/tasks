package concurrency.futures;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import concurrency.Task;
import concurrency.Threading;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

public class CompletableFutureExample extends Threading {

  public static void main(String[] args) {
    ExecutorService executorService = fixedPool(5);

    Task task = new Task("tasko");

    CompletableFuture<String> result = supplyAsync(task::call, executorService)
        .thenApply(res -> res.concat(" APPLIED"));

    try {
      System.out.println(result.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    } finally {
      executorService.shutdown();
    }
  }
}
