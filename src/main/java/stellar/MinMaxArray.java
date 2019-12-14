package stellar;

/**
 *  Write a Java program to find the maximum and minimum value of an array.
 *  O(N)
 */
public class MinMaxArray {

  public static void main(String[] args) {
    int[] array = {5, 1, 7, 2, -1, 0, 2, 4};
    System.out.println(min(array));
    System.out.println(max(array));
  }

  private static int max(int[] array) {
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    return max;
  }

  private static int min(int[] array) {
    int min = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
      }
    }
    return min;
  }
}
