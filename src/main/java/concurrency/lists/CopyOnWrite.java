package concurrency.lists;

import concurrency.Job;
import concurrency.Threading;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWrite extends Threading {
  public static void main(String[] args) {
    List<String> list = new CopyOnWriteArrayList<>();
    List<Job> jobs = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      jobs.add(new ListJob("Job " + i, list));
    }

    jobs.forEach(CopyOnWrite::start);

    sleep(500);

    System.out.println(list.size());
  }
}
