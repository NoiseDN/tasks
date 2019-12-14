package concurrency.pools;

import concurrency.Job;
import concurrency.Threading;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ScheduledPoolExample extends Threading {
  public static void main(String[] args) {
    ScheduledExecutorService executor = scheduledPool(10);

    List<Job> jobs = generateJobs(100);

    println("Scheduling jobs to run in 1 SECOND...");

    List<Future> futures = jobs.stream()
        .map(job -> executor.schedule(job, 1, TimeUnit.SECONDS))
        .collect(Collectors.toList());

    sleep(2000);
    System.out.println("All jobs are " + (futures.stream().allMatch(Future::isDone) ? "done" : "not done"));

    executor.shutdown();
  }
}
