package concurrency.lists;

import concurrency.Job;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ListJob extends Job {

  private List<String> list;

  public ListJob(String name, List<String> list) {
    super(name);
    this.list = list;
  }

  @Override
  public void run() {
    list.add(String.valueOf(ThreadLocalRandom.current().nextInt()));
    println("Added list element");
  }
}
