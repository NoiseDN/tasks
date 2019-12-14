package concurrency.synchronizers;

import static java.lang.String.format;

import concurrency.Job;
import java.util.concurrent.CountDownLatch;

public class InitJob extends Job {

  private final CountDownLatch countDownLatch;

  public InitJob(String jobName, CountDownLatch countDownLatch) {
    super(jobName);
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
//    try {
//      countDownLatch.await();
    for (int i = 0; i < 5; i++) {
      println(format("Initializing... %s", countDownLatch.getCount()));
      sleep(500);
      countDownLatch.countDown();
    }
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    } finally {
//    }
  }
}
