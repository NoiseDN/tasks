package concurrency.synchronizers;

import concurrency.Job;
import concurrency.Threading;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;

public class CyclicBarrierExample extends Threading {

  public static void main(String[] args) {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(50, () -> System.out.println("TRIPPED"));
    List<Job> jobs = new ArrayList<>();

    for (int i = 0; i < 1_000; i++) {
      jobs.add(new CyclicBarrierJob("barrier-" + i, cyclicBarrier));
    }

    ExecutorService executorService = fixedPool(100);

    jobs.forEach(executorService::submit);

    executorService.shutdown();
  }
}
