package concurrency.pools;

import static java.lang.String.format;
import static org.awaitility.Awaitility.await;

import concurrency.Job;
import concurrency.Threading;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ScheduledPoolExample extends Threading {

  private static final int JOBS = 100;

  public static void main(String[] args) {
    ScheduledExecutorService executor = scheduledPool(10);

    List<Job> jobs = generateJobs(JOBS);

    println(format("Scheduling %s jobs to run in 1 SECOND...", JOBS));

    List<Future> futures = jobs.stream()
        .map(job -> executor.schedule(job, 1, TimeUnit.SECONDS))
        .collect(Collectors.toList());

    await().atMost(2, TimeUnit.SECONDS)
        .until(() -> futures.stream().allMatch(Future::isDone));

    executor.shutdown();
  }
}
