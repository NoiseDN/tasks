package concurrency.atomics;

public class Counter {

  // note volatile does not provide atomicity
  private volatile int value = 0;

  public void increment() {
    value++;
  }

  public void decrement() {
    value--;
  }

  public int getValue() {
    return value;
  }
}
