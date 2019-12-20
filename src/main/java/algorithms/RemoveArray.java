package algorithms;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Write a Java program to remove a specific element from an array.
 */
public class RemoveArray {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(option1()));
    System.out.println(Arrays.toString(option2()));
  }

  // O(log n)
  private static int[] option1() {
    int[] array = new int[]{5, 1, 7, 2, -1, 0, 2, 4};
    int[] newArray = new int[array.length - 1];

    int remove = -1;

    for (int i = 0; i < array.length; i++) {
      if (array[i] == remove) {
        System.arraycopy(array, 0, newArray, 0, i);
        System.arraycopy(array, i + 1, newArray, i, i - 1);
        break;
      }
    }
    return newArray;
  }

  // O(log n)
  private static int[] option2() {
    return Stream.of(5, 1, 7, 2, -1, 0, 2, 4)
        .filter(i -> i != -1)
        .mapToInt(Integer::intValue)
        .toArray();
  }
}
