package com.betterprogrammer2;

public class BetterProgrammerTask1 {

  private static void checkPalindrome(final String stringPalindrome, final boolean result) {

    System.out.println(stringPalindrome);

    if (result) {
      System.out.println(" is a palindrome");
    }
    else {
      System.out.println(" is not a palindrome");
    }
  }

  public static boolean isPalindrome(final String s) {
    /*
     * Definition: A palindrome is a string that reads the same forward and backward. For example,
     * "abcba" is a palindrome, "abab" is not. Please implement this method to return true if the
     * parameter is a palindrome and false otherwise.
     */

    boolean result = true;

    final int length = s.length();
    final char[] charArray = s.toCharArray();

    int numRepeat = length / 2;
    if ((length % 2) != 0) {
      // is impair
      numRepeat--;
    }

    final int lastPosition = length - 1;

    for (int i = 0; i < numRepeat; i++) {
      final char charRigth = charArray[lastPosition - i];
      final char charLeft = charArray[i];

      System.out.println(charLeft + " " + charRigth);
      if (charLeft != charRigth) {
        result = false;
        break;
      }
    }

    return result;
  }

  public static void main(final String argv[]) {

    final String stringPalindrome = "abcba";
    final String stringNoPalindrome = "abab";

    boolean result = isPalindrome(stringPalindrome);

    checkPalindrome(stringPalindrome, result);

    result = isPalindrome(stringNoPalindrome);
    checkPalindrome(stringNoPalindrome, result);
  }
}
