package concurrency.util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Await {

  private int value;
  private TimeUnit unit;

  public Await(int value, TimeUnit unit) {
    this.value = value;
    this.unit = unit;
  }

  public static Await atMost(int value, TimeUnit unit) {
    return new Await(value, unit);
  }

  public void until(Supplier<Boolean> supplier) {

    while(true) {
      if (supplier.get()) {
        return;
      }

    }
  }
}
