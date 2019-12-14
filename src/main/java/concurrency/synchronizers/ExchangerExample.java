package concurrency.synchronizers;

import concurrency.Entity;
import concurrency.Job;
import concurrency.Threading;
import java.util.concurrent.Exchanger;

public class ExchangerExample extends Threading {
  public static void main(String[] args) {
    Exchanger<Entity> entityExchanger = new Exchanger<>();

    Entity entityOne = new Entity("1", "one");
    Entity entityTwo = new Entity("2", "two");

    Job jobOne = new ExchangerJob("job-1", entityOne, entityExchanger);
    Job jobTwo = new ExchangerJob("job-2", entityTwo, entityExchanger);

    start(jobOne);
    start(jobTwo);
  }
}
