package concurrency.locks;

import concurrency.Job;

public class ComputeJob extends Job {

  private final LongEntity entity;
  private final Long value;

  public ComputeJob(String jobName, LongEntity entity, Long value) {
    super(jobName);
    this.entity = entity;
    this.value = value;
  }

  @Override
  public void run() {
    entity.computeValue(value);
    println("Computed new value: " + entity.getValue());
  }
}
