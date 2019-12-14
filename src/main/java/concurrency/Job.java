package concurrency;

public class Job implements T, Runnable {

  private final String jobName;

  public Job(String jobName) {
    this.jobName = jobName;
  }

  public void run() {
    println("Job done");
  }

  @Override
  public String getName() {
    return jobName;
  }
}
