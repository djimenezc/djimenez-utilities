package com.betterprogrammer1;

public class BetterProgrammerTask4 {

  static final int PENNY = 1;
  static final int NICKEL = 5;
  static final int DIME = 10;
  static final int QUARTER = 25;
  static final int HALF_DOLLAR = 50;

  public static int countWaysToProduceGivenAmountOfMoney(final int cents) {
    /*
     * Please implement this method to return the number of different combinations of US coins
     * (penny: 1c, nickel: 5c, dime: 10c, quarter: 25c, half-dollar: 50c) which may be used to
     * produce a given amount of money. For example, 11 cents can be produced with one 10-cent coin
     * and one 1-cent coin, two 5-cent coins and one 1-cent coin, one 5-cent coin and six 1-cent
     * coins, or eleven 1-cent coins. So there are four unique ways to produce 11 cents. Assume that
     * the cents parameter is always positive.
     */

    int result = formWith(cents, HALF_DOLLAR);
    result += formWith(cents, QUARTER);
    result += formWith(cents, DIME);
    result += formWith(cents, NICKEL);
    result += formWith(cents, PENNY);

    return result;
  }

  private static int formWith(final int cents, final int coinValue) {

    int result = 0;
    final int numCoins = cents / coinValue;
    final int rest = cents % coinValue;

    if (numCoins == 1) {

      if (rest == 0) {
        result++;
      }
      else {
        result += countWaysToProduceGivenAmountOfMoney(rest);
      }
    }
    else if ((numCoins > 1) && (rest != 0)) {

      result += formWith(cents - rest, coinValue);
    }

    if ((numCoins > 1) && (rest == 0)) {

      result++;
    }

    return result;
  }

  /**
   * @param argv
   */
  public static void main(final String argv[]) {

    final int cents = 11;
    final int expectResult = 4;

    final int result = countWaysToProduceGivenAmountOfMoney(cents);

    if (result == expectResult) {
      System.out.println("The different combintation are: " + result);
    }
    else {
      System.out.println("Error, result expected: " + expectResult + ", result calculated: "
        + result);
    }

  }
}
