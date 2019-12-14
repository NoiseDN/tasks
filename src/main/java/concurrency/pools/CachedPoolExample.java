package concurrency.pools;

import static java.lang.String.format;
import static org.awaitility.Awaitility.await;

import concurrency.Job;
import concurrency.Threading;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CachedPoolExample extends Threading {

  private static final int JOBS = 100_000;

  public static void main(String[] args) {
    logStart();
    ExecutorService executor = cachedPool();

    List<Job> jobs = generateJobs(JOBS);

    println(format("Executing %s jobs...", JOBS));

    List<Future> futures = jobs.stream()
        .map(executor::submit)
        .collect(Collectors.toList());

    await().atMost(2, TimeUnit.SECONDS)
        .until(() -> futures.stream().allMatch(Future::isDone));

    System.out.println(format("%s jobs are done in %sms", jobs.size(), timing()));

    executor.shutdown();
  }
}
