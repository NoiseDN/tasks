package concurrency.atomics;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter extends Counter {

  private volatile AtomicInteger value = new AtomicInteger();

  @Override
  public void increment() {
    value.incrementAndGet();
  }

  @Override
  public void decrement() {
    value.decrementAndGet();
  }

  @Override
  public int getValue() {
    return value.get();
  }
}
