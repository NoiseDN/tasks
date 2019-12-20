package algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a Java program to find the common elements between two arrays (string values).
 * O(N^2)
 */
public class CommonElements {
  public static void main(String[] args) {
    String[] arrayOne = new String[]{"A", "2", "c", "A", "-1", "0", "c", "A", "2"};
    String[] arrayTwo = new String[]{"V", "2", "d", "-1"};

    System.out.println(commonElements(arrayOne, arrayTwo));
  }

  private static Set<String> commonElements(String[] arrayOne, String[] arrayTwo) {
    Set<String> commons = new HashSet<>();

    for (String left : arrayOne) {
      for (String right : arrayTwo) {
        if (left.equals(right)) {
          commons.add(left);
        }
      }
    }

    return commons;
  }
}
