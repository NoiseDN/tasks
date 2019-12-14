package concurrency.atomics;

import concurrency.Job;

public class CounterIncrementJob extends Job {

  private final Counter counter;

  public CounterIncrementJob(String jobName, Counter counter) {
    super(jobName);
    this.counter = counter;
  }

  @Override
  public void run() {
    counter.increment();
//    println("Incremented. Value is " + counter.getValue());
  }
}
