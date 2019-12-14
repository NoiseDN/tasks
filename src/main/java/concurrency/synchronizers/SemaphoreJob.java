package concurrency.synchronizers;

import static java.lang.String.format;

import concurrency.Job;
import java.util.concurrent.Semaphore;

public class SemaphoreJob extends Job {

  private volatile Semaphore semaphore;

  public SemaphoreJob(String name, Semaphore semaphore) {
    super(name);
    this.semaphore = semaphore;
  }

  @Override
  public void run() {
    try {
      println("Acquiring permit...");
      semaphore.acquire();
      println(format("Acquired. Available: %s", semaphore.availablePermits()));
      sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      semaphore.release();
      println(format("Released. Available: %s", semaphore.availablePermits()));
    }
  }
}
