package concurrency.synchronizers;

import concurrency.Job;
import concurrency.Threading;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

public class SemaphoreExample extends Threading {
  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(5);
    List<Job> jobs = new ArrayList<>();

    for (int i = 0; i < 1_000; i++) {
      jobs.add(new SemaphoreJob("job-" + i, semaphore));
    }

    ExecutorService executorService = fixedPool(10);

    jobs.forEach(executorService::submit);

    executorService.shutdown();
  }
}
