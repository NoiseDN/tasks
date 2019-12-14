package concurrency.pools;

import concurrency.Job;
import concurrency.Threading;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class FixedPoolExample extends Threading {
  public static void main(String[] args) {
    ExecutorService executor = fixedPool(10);

    List<Job> jobs = generateJobs(100);

    List<Future> futures = jobs.stream()
        .map(executor::submit)
        .collect(Collectors.toList());

//    Await.atMost(5, TimeUnit.SECONDS)
//        .until(() -> futures.stream().allMatch(Future::isDone));

    sleep(2000);
    System.out.println("All jobs are " + (futures.stream().allMatch(Future::isDone) ? "done" : "not done"));

    executor.shutdown();
  }
}
