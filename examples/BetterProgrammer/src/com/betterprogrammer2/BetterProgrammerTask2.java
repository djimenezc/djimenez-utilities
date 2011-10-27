package com.betterprogrammer2;

public class BetterProgrammerTask2 {

  public static void main(final String argv[]) {

    final int[] array = { 10, 20, 5, 50, 60, 10 };

    final int result = sumOfTwoLargestElements(array);

    System.out.println("The sum of the biggest number is: " + result);
  }

  public static int sumOfTwoLargestElements(final int[] a) {
    /*
     * Please implement this method to return the sum of the two largest numbers in a given array.
     */

    int secondBig = 0;
    int firstBig = 0;

    for (final int element : a) {

      if (element > firstBig) {
        secondBig = firstBig;
        firstBig = element;
      }
      else {
        if (element > secondBig) {
          secondBig = element;
        }
      }

    }

    final int result = firstBig + secondBig;

    return result;
  }
}
