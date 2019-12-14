package concurrency.synchronizers;

import concurrency.Job;
import concurrency.Threading;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public class CountDownLatchExample extends Threading {

  public static void main(String[] args) {
    CountDownLatch countDownLatch = new CountDownLatch(5);

    List<Job> jobs = new ArrayList<>();

    jobs.add(new InitJob("init-job", countDownLatch));

    for (int i = 0; i < 10; i++) {
      jobs.add(new WorkJob("work-job-" + i, countDownLatch));
    }

    ExecutorService executorService = fixedPool(10);

    jobs.forEach(executorService::submit);

    executorService.shutdown();
  }
}
