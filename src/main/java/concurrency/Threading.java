package concurrency;

import static java.lang.String.format;

import concurrency.pools.SlowJob;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Threading {

  private static long start;

  protected static void start(Job job) {
    new Thread(job).start();
  }

  protected static void logStart() {
    start = System.currentTimeMillis();
  }

  protected static long timing() {
    return System.currentTimeMillis() - start;
  }

  protected static void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected static String getThreadName() {
    return Thread.currentThread().getName();
  }

  protected static synchronized void println(String string) {
    System.out.println(format("[%s] %s", getThreadName(), string));
  }

  protected static ExecutorService fixedPool(int numberOfThreads) {
    return Executors.newFixedThreadPool(numberOfThreads);
  }

  protected static ExecutorService stealingPool() {
    return Executors.newWorkStealingPool();
  }

  protected static ExecutorService cachedPool() {
    return Executors.newCachedThreadPool();
  }

  protected static ScheduledExecutorService scheduledPool(int size) {
    return Executors.newScheduledThreadPool(size);
  }

  protected static List<Job> generateJobs(int count) {
    return generateJobs(count, false);
  }

  protected static List<Job> generateJobs(int count, boolean slow) {
    return Stream.iterate(0, i -> i = i + 1)
        .limit(count)
        .map(i -> slow ? new SlowJob("slow-" + i) : new Job("job-" + i))
        .collect(Collectors.toList());
  }
}
