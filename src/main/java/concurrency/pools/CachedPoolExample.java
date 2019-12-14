package concurrency.pools;

import concurrency.Job;
import concurrency.Threading;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class CachedPoolExample extends Threading {
  public static void main(String[] args) {
    ExecutorService executor = cachedPool();

    List<Job> jobs = generateJobs(100);

    List<Future> futures = jobs.stream()
        .map(executor::submit)
        .collect(Collectors.toList());

    sleep(2000);
    System.out.println("All jobs are " + (futures.stream().allMatch(Future::isDone) ? "done" : "not done"));

    executor.shutdown();
  }
}
