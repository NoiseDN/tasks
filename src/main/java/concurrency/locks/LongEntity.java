package concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LongEntity {

  private Long value;
  private Long otherValue;

  private final Lock valueLock = new ReentrantLock(true);
  private final Lock otherValueLock = new ReentrantLock(true);

  public LongEntity(Long initialValue) {
    this.value = initialValue;
    this.otherValue = initialValue;
  }

  public void computeValue(Long value) {
    valueLock.lock();
    try {
      this.value *= value;
    } finally {
      valueLock.unlock();
    }
  }

  public void computeOtherValue(Long value) {
    otherValueLock.lock();
    try {
      this.otherValue *= value;
    } finally {
      otherValueLock.unlock();
    }
  }

  public Long getValue() {
    return value;
  }

  public Long getOtherValue() {
    return otherValue;
  }
}
