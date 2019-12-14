package concurrency.maps;

import concurrency.Entity;
import java.util.Map;

public class ReadMapJob extends MapJob {

  public ReadMapJob(String name, Map<String, Entity> map) {
    super(name, map);
  }

  @Override
  public void run() {
    println("Got element: " + randomValue());
  }
}
