package concurrency.locks;

import concurrency.Job;
import java.util.List;

public class AddJob extends Job {

  private final int index;
  private volatile List<String> list;

  public AddJob(int index, List<String> list) {
    super("job-" + index);
    this.index = index;
    this.list = list;
  }

  @Override
  public void run() {
    list.add(index + "");
    println("Added " + index);
  }
}
