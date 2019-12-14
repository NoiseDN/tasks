package concurrency.synchronizers;

import static java.lang.String.format;

import concurrency.Entity;
import concurrency.Job;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ThreadLocalRandom;

public class ExchangerJob extends Job {

  private volatile Exchanger<Entity> exchanger;
  private Entity entity;

  public ExchangerJob(String name, Entity entity, Exchanger<Entity> exchanger) {
    super(name);
    this.entity = entity;
    this.exchanger = exchanger;
  }

  @Override
  public void run() {
    try {
      int toSleep = ThreadLocalRandom.current().nextInt(5000);
      println(format("Exchanging %s in %sms...", entity.getName(), toSleep));
      sleep(toSleep);
      Entity caught = exchanger.exchange(entity);
      println(format("Caught: %s", caught.getName()));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
