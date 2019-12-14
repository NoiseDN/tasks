package concurrency.synchronizers;

import static java.lang.String.format;

import concurrency.Job;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierJob extends Job {

  private volatile CyclicBarrier cyclicBarrier;

  public CyclicBarrierJob(String name, CyclicBarrier cyclicBarrier) {
    super(name);
    this.cyclicBarrier = cyclicBarrier;
  }

  @Override
  public void run() {
    try {
      println("Starting...");
      cyclicBarrier.await();
      sleep(300);
      println(format("Working... [waiting: %s]", cyclicBarrier.getNumberWaiting()));
    } catch (BrokenBarrierException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
