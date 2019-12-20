package algorithms;

import java.util.Arrays;

/**
 * Write a Java program to sort a numeric array and a string array.
 */
public class SortArray {
  int[] numArray;
  String[] strArray;

  public SortArray(int[] numArray) {
    this.numArray = numArray;
  }

  public SortArray(String[] strArray) {
    this.strArray = strArray;
  }

  public int[] numSorted() {
    return Arrays.stream(numArray).sorted().toArray();
  }

  public String[] strSorted() {
    return Arrays.stream(strArray).sorted().toArray(String[]::new);
  }

  public static void main(String[] args) {
    System.out.println(Arrays
        .toString(new SortArray(new int[] { 5, 1, 7, 2, -1, 0, 2, 4 })
        .numSorted()));
    System.out.println(Arrays
        .toString(new SortArray(new String[] { "A", "c", "123", "-51531", "ZZ", "O", "0", "t" })
        .strSorted()));
  }
}
