package stellar;

import java.util.Arrays;

/**
 * Write a Java program to sum values of an array.
 */
public class SumArray {
  int[] numArray;

  public SumArray(int[] numArray) {
    this.numArray = numArray;
  }

  public int sum() {
    return Arrays.stream(numArray).sum();
  }

  public static void main(String[] args) {
    System.out.println(new SumArray(new int[] { 5, 1, 7, 2, -1, 0, 2, 4 }).sum());
  }
}
