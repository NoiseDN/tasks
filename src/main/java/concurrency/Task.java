package concurrency;

import static java.lang.String.format;

import java.util.concurrent.Callable;

public class Task implements T, Callable<String> {

  private final String taskName;

  public Task(String taskName) {
    this.taskName = taskName;
  }

  @Override
  public String getName() {
    return taskName;
  }

  @Override
  public String call() {
    sleep(2000);
    return format("Task %s done", taskName);
  }
}
