package algorithms;

/**
 * Write a Java program to print the following grid. Go to the editor
 *
 * Expected Output :
 *
 * - - - - - - - - - -
 * - - - - - - - - - -
 * - - - - - - - - - -
 * - - - - - - - - - -
 * - - - - - - - - - -
 * - - - - - - - - - -
 * - - - - - - - - - -
 * - - - - - - - - - -
 * - - - - - - - - - -
 * - - - - - - - - - -
 */
public class Grid {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        System.out.print("_ ");
      }
      System.out.print("\n");
    }
  }
}
