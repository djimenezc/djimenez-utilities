package com.betterprogrammer2;

public class BetterProgrammerTask4 {

  private static final int STE_NUMBER = 4;

  private static final int RESULT_EXPECTED = 5;
  private static final int[] KIND_STEPS = { 1, 2 };

  private static int advance(final int stepValue, final int stairSize) {

    int result = 0;

    if (stairSize == 0) {
      System.out.println("sum 1");
      result = 1;
    }
    else if (stairSize > 0) {
      result = countWaysToJump(stairSize);
    }

    return result;
  }

  public static int countWaysToJump(final int N) {
    /*
     * A set of stairs has N steps. You can jump either 1 or 2 steps at a time. For example, if the
     * stairs is N=4 steps, you can reach the end in 5 possible ways: 1-1-1-1, or 1-2-1 or 1-1-2 or
     * 2-1-1 or 2-2 Please implement this method to return the count of the different ways to reach
     * the end of the stairs with N steps.
     */

    int advanceStep = 0;

    for (final int stepValue : KIND_STEPS) {
      System.out.println(" Step " + stepValue + " ");
      advanceStep += advance(stepValue, N - stepValue);
    }

    return advanceStep;
  }

  public static void main(final String argv[]) throws Exception {

    final int result = countWaysToJump(STE_NUMBER);

    String message= "number of ways: " + result;
    
    System.out.println(message);

    if (result != RESULT_EXPECTED) {
      throw new Exception("The method countWaysToJump is working bad");
    }
  }
}
