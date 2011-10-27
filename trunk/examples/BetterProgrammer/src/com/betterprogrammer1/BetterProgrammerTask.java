package com.betterprogrammer1;

public class BetterProgrammerTask {

  static final int CLOSE_ELEMENT = 0;

  /**
   * @param a
   * @return
   */
  /**
   * @param a
   * @return
   */
  public static int getClosestToZero(final int[] a) {
    /*
     * Please implement this method to return the number in the array that is closest to zero. If
     * there are two equally close to zero elements like 2 and -2 - consider the positive element to
     * be "closer" to zero.
     */

    int result = Integer.MAX_VALUE;

    for (final int element : a) {

      final int absElementValue = Math.abs(element);

      if (Math.abs(result) >= absElementValue) {
        if (((absElementValue == Math.abs(result)) && (element > CLOSE_ELEMENT))
          || (absElementValue != Math.abs(result))) {
          result = element;
        }
      }
    }

    return result;
  }

  public static void main(final String argv[]) {

    final int[] array = { 10, 20, -2, 2, -2, -3, -1, 1, -1, 10, -2 };

    final int result = getClosestToZero(array);

    System.out.println("The closest to " + CLOSE_ELEMENT + " is: " + result);

  }
}
