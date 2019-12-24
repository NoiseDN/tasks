package oop;

public class Developer extends Worker {
  public Developer(String id) {
    super(id);
  }

  @Override
  public boolean work() {
    print("Coding...");
    return true;
  }

  @Override
  public boolean walk() {
    print("Riding on a chair...");
    return true;
  }

  @Override
  public boolean talk() {
    print("Shouting...");
    return true;
  }
}
