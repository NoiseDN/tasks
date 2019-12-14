package concurrency.maps;

import concurrency.Entity;
import java.util.Map;

public class PutMapJob extends MapJob {

  public PutMapJob(String name, Map<String, Entity> map) {
    super(name, map);
  }

  @Override
  public void run() {
    sleep(100);
    map.put(randomString(), new Entity(randomString(), randomString()));
    println("Added new element");
  }
}
