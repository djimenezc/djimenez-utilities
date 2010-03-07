package com.djimenez.util.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that handles validate with regular expression. A compiled
 * representation of a regular expression.
 * <p>
 * A regular expression, specified as a string, must first be compiled into an
 * instance of this class. All of the state involved in performing a match
 * resides in the matcher, so many matchers can share the same pattern.
 * <p>
 * A typical invocation sequence is thus
 * 
 * @author jlp002es
 * @version 1.0
 * @see es.dia.pos.n2a.util.StringHelperFO
 */
public final class ValidateExpresionRegularHelperFO {

  private final Pattern pattern;
  private final String patterDescription;

  public ValidateExpresionRegularHelperFO(final String patterDescription) {
    this.patterDescription = patterDescription;
    this.pattern = Pattern.compile(this.patterDescription);
  }

  public boolean isValid(final String input) {
    final Matcher matcher = pattern.matcher(input);
    return matcher.matches();
  }

  public void getMatcher(final String input) {
    final Matcher matcher = pattern.matcher(input);
    matcher.find();
  }

}
