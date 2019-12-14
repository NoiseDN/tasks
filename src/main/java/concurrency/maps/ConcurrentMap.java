package concurrency.maps;

import concurrency.Entity;
import concurrency.Job;
import concurrency.Threading;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMap extends Threading {
  public static void main(String[] args) {
    Map<String, Entity> map = new ConcurrentHashMap<>(0, .7f, 16);
    List<Job> jobs = new ArrayList<>();

    for (int i = 0; i < 1; i++) {
      jobs.add(new PutMapJob("Job " + i, map));
    }

    for (int i = 0; i < 1_000; i++) {
      jobs.add(new ReadMapJob("Job " + i, map));
    }

    jobs.forEach(Threading::start);
  }
}
