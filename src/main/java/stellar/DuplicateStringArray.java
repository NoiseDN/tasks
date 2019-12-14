package stellar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a Java program to find the duplicate values of an array of string values.
 * O(N)
 */
public class DuplicateStringArray {
  public static void main(String[] args) {
    String[] array = new String[]{"A", "2", "c", "A", "-1", "0", "c", "A", "2"};

    System.out.println(duplicates(array));
  }

  private static Set<String> duplicates(String[] array) {
    Arrays.sort(array);
    Set<String> duplicates = new HashSet<>();
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i].equals(array[i + 1])) {
        duplicates.add(array[i]);
      }
    }
    return duplicates;
  }
}
