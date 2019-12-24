package oop;

public class OopExample {

  public static void main(String[] args) {
    Entity david = new Developer("Entity David");
    david.getId();

    Alive alive = new Worker("Alive Worker");
    alive.getId();
    alive.breathe();

    Human human = new Developer("Human Manasa");
    human.getId();
    human.breathe();
    human.walk();

    Person person = new Worker("Person Tad");
    person.getId();
    person.breathe();
    person.walk();
    person.talk();

    Worker worker = new Worker("Worker Ryan");
    worker.getId();
    worker.breathe();
    worker.walk();
    worker.talk();
    worker.work();

    Developer developer = new Developer("Dev Anton");
    developer.getId();
    developer.breathe();
    developer.walk();
    developer.talk();
    developer.work();

  }
}
