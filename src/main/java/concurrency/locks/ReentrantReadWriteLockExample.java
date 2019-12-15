package concurrency.locks;

import static org.awaitility.Awaitility.await;

import concurrency.Threading;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class ReentrantReadWriteLockExample extends Threading {

  public static void main(String[] args) {
    List<Runnable> jobs = new ArrayList<>();
    LongEntity entity = new LongEntity(1L);

    for (int i = 1; i < 10; i++) {
      jobs.add(new ComputeJob("cmp-" + i, entity, 2L * i));
      jobs.add(new ComputeOtherJob("cmp-oth-" + i, entity, 3L * i));
    }

    ExecutorService pool = fixedPool(20);

    jobs.forEach(pool::submit);

    pool.shutdown();

    await().until(pool::isTerminated);

    println(entity.getValue().toString());
    println(entity.getOtherValue().toString());
  }
}
