package algorithms;

import java.util.Arrays;

/**
 * Write a Java program to test if an array contains a specific value.
 * O(log n)
 */
public class ContainsArray {
  int[] numArray;

  public ContainsArray(int[] numArray) {
    this.numArray = numArray;
  }

  public boolean contains(int value) {
    return Arrays.stream(numArray).anyMatch(i -> i == value);
  }

  public static void main(String[] args) {
    System.out.println(new ContainsArray(new int[] { 5, 1, 7, 2, -1, 0, 2, 4 }).contains(5784784));
  }
}
