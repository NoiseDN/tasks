package concurrency.atomics;

import concurrency.Job;
import concurrency.Threading;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.stream.Stream;

public class CounterExample extends Threading {

  private static final boolean ATOMIC = false;

  private static final int ADDITIONS = 400;
  private static final int SUBTRACTIONS = 200;
  private static final int ITERATIONS = 50;

  public static void main(String[] args) {
    Stream.iterate(0, i -> i + 1)
        .limit(ITERATIONS)
        .forEach(i -> println("Iteration " + i + ": value is " + doTask(ATOMIC).getValue()));
  }

  private static Counter doTask(boolean atomic) {
    Counter counter = atomic ? new AtomicCounter() : new Counter();
    List<Job> jobs = new ArrayList<>();

    for (int i = 0; i < ADDITIONS; i++) {
      jobs.add(new CounterIncrementJob("inc-" + i, counter));
    }
    for (int i = 0; i < SUBTRACTIONS; i++) {
      jobs.add(new CounterDecrementJob("dec-" + i, counter));
    }

    ExecutorService pool = cachedPool();

    jobs.forEach(pool::submit);

    pool.shutdown();

    return counter;
  }
}
