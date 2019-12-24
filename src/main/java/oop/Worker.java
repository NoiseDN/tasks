package oop;

public class Worker implements Person {

  private final String id;

  public Worker(String id) {
    this.id = id;
  }

  @Override
  public boolean talk() {
    print("Talking...");
    return true;
  }

  @Override
  public boolean walk() {
    print("Walking...");
    return true;
  }

  @Override
  public boolean breathe() {
    print("Breating...");
    return true;
  }

  @Override
  public String getId() {
    return id;
  }

  public boolean work() {
    print("Working...");
    return true;
  }
}
