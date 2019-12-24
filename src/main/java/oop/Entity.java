package oop;

import static java.lang.String.format;

public interface Entity {
  String getId();

  default void print(String message) {
    System.out.println(format("[%s] %s", getId(), message));
  }
}
