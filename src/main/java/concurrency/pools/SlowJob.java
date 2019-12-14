package concurrency.pools;

import concurrency.Job;

public class SlowJob extends Job {

  public SlowJob(String jobName) {
    super(jobName);
  }

  @Override
  public void run() {
    sleep(random(1000));
    println("Job done");
  }
}
