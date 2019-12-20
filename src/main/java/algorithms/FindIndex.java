package algorithms;

/**
 * Write a Java program to find the index of an array element.
 * O(log n)
 */
public class FindIndex {
  int[] numArray;

  public FindIndex(int[] numArray) {
    this.numArray = numArray;
  }

  public int getIndex(int value) {
    for (int i = 0; i < numArray.length; i++) {
      if (numArray[i] == value) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(new FindIndex(new int[] { 5, 1, 7, 2, -1, 0, 2, 4 }).getIndex(7));
  }
}
