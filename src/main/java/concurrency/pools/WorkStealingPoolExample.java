package concurrency.pools;

import concurrency.Threading;
import java.util.concurrent.ExecutorService;

public class WorkStealingPoolExample extends Threading {
  public static void main(String[] args) {
    ExecutorService executor = stealingPool();

  }
}
