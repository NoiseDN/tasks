package stellar;

import java.util.Arrays;

/**
 * Write a Java program to insert an element (specific position) into an array.
 * O(1)
 */
public class InsertArray {

  public static void main(String[] args) {
    int[] array = new int[] {5, 1, 7, 2, -1, 0, 2, 4};

    System.out.println(Arrays.toString(array));
    System.out.println(Arrays.toString(insert(array, 9999, 6)));
  }

  private static int[] insert(int[] array, int element, int position) {
    int[] tempArray = new int[array.length + 1];
    System.arraycopy(array, 0, tempArray, 0, position);
    System.arraycopy(array, position, tempArray, position + 1, array.length - position);
    tempArray[position] = element;
    return tempArray;
  }
}
