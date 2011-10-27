package com.betterprogrammer1;

public class BetterProgrammerTask2 {

  public static String getBinaryRepresentation(final int n) {
    /*
     * Please implement this method to return a String with the binary representation of any number
     * n, where n >= 0. Example: "101" is a binary representation of 5
     */
    String result = "";

    if (n >= 0) {
      result = Integer.toBinaryString(n);
    }
    else {
      result = "the number must be positive";
    }
    return result;
  }

  /**
   * @param argv
   */
  /**
   * @param argv
   */
  public static void main(final String argv[]) {

    final int value = -5;

    final String result = getBinaryRepresentation(value);

    final String expectResult = "101";

    if (result.equals(expectResult)) {
      System.out.println("The binary representation of " + value + " is: " + result);
    }
    else {
      System.out.println("Error, result expected: " + expectResult + ", result calculated: "
        + result);
    }
  }
}
