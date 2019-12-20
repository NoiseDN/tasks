package algorithms;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a Java program to remove duplicate elements from an array.
 */
public class RemoveDuplicateArray {

  public static void main(String[] args) {
    int[] array = {5, 1, 7, 2, -1, 0, 2, 4, 2, 4, -1, 0, 2, 4, 1, -1, 9, 11, 32};

    System.out.println(Arrays.toString(array));
    System.out.println(removeDuplicates(array));
  }

  private static List<Integer> removeDuplicates(int[] array) {
    List<Integer> elements = Arrays.stream(array).boxed().collect(toList());
    Set<Integer> duplicates = duplicates(array.clone());

    elements.removeIf(duplicates::contains);
    elements.addAll(duplicates);

    return elements;
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
