package stellar;

import java.util.Arrays;

/**
 * Write a Java program to reverse an array of integer values.
 * O(n)
 */
public class ReverseArray {
  public static void main(String[] args) {
    int[] array = new int[] {5, 1, 7, 2, -1, 0, 2, 4};

    System.out.println(Arrays.toString(array));
    System.out.println(Arrays.toString(reverse(array)));
  }

  private static int[] reverse(int[] array) {
    int[] reversed = new int[array.length];
    for (int i = 0, r = reversed.length - 1; i < array.length; i++, r--) {
      reversed[r] = array[i];
    }
    return reversed;
  }
}
