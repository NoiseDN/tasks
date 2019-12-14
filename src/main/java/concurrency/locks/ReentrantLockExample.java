package concurrency.locks;

import static org.awaitility.Awaitility.await;

import concurrency.Threading;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class ReentrantLockExample extends Threading {

  public static void main(String[] args) {
    List<String> list = new SlowList();
    List<Runnable> jobs = new ArrayList<>();

    for (int i = 0; i < 30; i++) {
      jobs.add(new AddJob(i, list));
    }

    ExecutorService pool = fixedPool(10);

    jobs.forEach(pool::submit);

    pool.shutdown();

    await().until(pool::isTerminated);

    println(list.toString());
  }
}
