package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a Java program to find the duplicate values of an array of integer values
 * O(n)
 */
public class DuplicateArray {

  public static void main(String[] args) {
    int[] array = {5, 1, 7, 2, -1, 0, 2, 4, 2, 4, -1, 0, 2, 4, 1, -1};

    System.out.println(duplicates(array));
  }

  private static Set<Integer> duplicates(int[] array) {
    Arrays.sort(array);
    Set<Integer> duplicates = new HashSet<>();
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] == array[i + 1]) {
        duplicates.add(array[i]);
      }
    }
    return duplicates;
  }
}
