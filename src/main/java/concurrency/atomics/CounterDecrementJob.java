package concurrency.atomics;

import concurrency.Job;

public class CounterDecrementJob extends Job {

  private final Counter counter;

  public CounterDecrementJob(String jobName, Counter counter) {
    super(jobName);
    this.counter = counter;
  }

  @Override
  public void run() {
    counter.decrement();
//    println("Decremented. Value is " + counter.getValue());
  }
}
