package concurrency;

import static java.lang.String.format;

import java.util.concurrent.ThreadLocalRandom;

public interface T {

  String getName();

  default String getThreadName() {
    return Thread.currentThread().getName();
  }

  default void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  default int random(int bound) {
    return ThreadLocalRandom.current().nextInt(bound);
  }

  default String randomString() {
    return String.valueOf(ThreadLocalRandom.current().nextInt());
  }

  default void println(String string) {
    System.out.println(format("[%s:%s] %s", getThreadName(), getName(), string));
  }

}
