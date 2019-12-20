package algorithms;

import java.util.Arrays;

/**
 *  Write a Java program to calculate the average value of array elements.
 */
public class AvgArray {
  int[] numArray;

  public AvgArray(int[] numArray) {
    this.numArray = numArray;
  }

  public double avg() {
    return Arrays.stream(numArray).average().getAsDouble();
  }

  public static void main(String[] args) {
    System.out.println(new AvgArray(new int[] { 5, 1, 7, 2, -1, 0, 2, 4 }).avg());
  }

}
