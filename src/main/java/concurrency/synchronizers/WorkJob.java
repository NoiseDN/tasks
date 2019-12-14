package concurrency.synchronizers;

import concurrency.Job;
import java.util.concurrent.CountDownLatch;

public class WorkJob extends Job {

  private final CountDownLatch countDownLatch;

  public WorkJob(String jobName, CountDownLatch countDownLatch) {
    super(jobName);
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    try {
      countDownLatch.await();
      println("Working...");
      sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
