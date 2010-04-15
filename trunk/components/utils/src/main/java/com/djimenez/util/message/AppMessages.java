package com.djimenez.util.message;

import java.text.MessageFormat;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.djimenez.util.internationalization.InternationalizationContextHolder;

/**
 * @author sara.gonzalez.ming
 */
public class AppMessages {

  private static Logger logger = Logger.getLogger(AppMessages.class);

  private final ResourceBundle resourceBundle;
  private final ResourceBundle crossResourceBundle;

  protected AppMessages(final String messagesFile) {
    this.resourceBundle =
      ResourceBundle.getBundle(messagesFile, InternationalizationContextHolder
        .getInstance().getLocale());
    this.crossResourceBundle =
      ResourceBundle.getBundle("cross-messages",
        InternationalizationContextHolder.getInstance().getLocale());
  }

  public final String getMessage(final String message) {
    String totalText = null;
    try {
      totalText = this.resourceBundle.getString(message);
    }
    catch (final MissingResourceException e) {
      logger.debug("Message " + message
        + " not found for module. Looking on cross messages");
    }
    if (totalText == null) {
      totalText = this.crossResourceBundle.getString(message);
    }
    String returnText = "";
    if (totalText.contains("#")) {
      final String[] subTexts = totalText.split("#");
      for (final String subText : subTexts) {
        try {
          returnText = returnText.concat(this.getMessage(subText));
        }
        catch (final Exception e) {
          returnText = returnText.concat(subText);
        }
      }
    }
    else {
      returnText = totalText;
    }

    return returnText;
  }

  public final String getMessage(final String message,
    final List<Object> arguments) {
    return this.getMessage(message, arguments.toArray());
  }

  public final String getMessage(final String message, final Object[] arguments) {
    final String text = this.getMessage(message);
    final MessageFormat messageFormat = new MessageFormat(text);
    return messageFormat.format(arguments);
  }

  public final String getValue(final String key) {
    return this.getMessage(key);
  }
}
