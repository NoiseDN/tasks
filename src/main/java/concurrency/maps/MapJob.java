package concurrency.maps;

import concurrency.Entity;
import concurrency.Job;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class MapJob extends Job {

  private final static Random RANDOM = new Random();

  protected Map<String, Entity> map;

  public MapJob(String name, Map<String, Entity> map) {
    super(name);
    this.map = map;
  }

  protected Entity randomValue() {
    if (map.isEmpty()) {
      return null;
    }
    List<String> keyList = new ArrayList<>(map.keySet());
    String randomKey = keyList.get(RANDOM.nextInt(keyList.size()));

    return map.get(randomKey);
  }
}
