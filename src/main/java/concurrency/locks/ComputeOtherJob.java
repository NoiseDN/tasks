package concurrency.locks;

import concurrency.Job;

public class ComputeOtherJob extends Job {

  private final LongEntity entity;
  private final Long value;

  public ComputeOtherJob(String jobName, LongEntity entity, Long value) {
    super(jobName);
    this.entity = entity;
    this.value = value;
  }

  @Override
  public void run() {
    entity.computeOtherValue(value);
    println("Computed other value: " + entity.getValue());
  }
}
