package com.gowex.facebook;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

public class Example {

  private static FacebookClient facebookClient;

  public static void main(final String[] args) {

    final String accessToken = "";

    facebookClient = new DefaultFacebookClient(accessToken);

    final User user = facebookClient.fetchObject("me", User.class);

  }

  Example(final String accessToken) {
    facebookClient = new DefaultFacebookClient(accessToken);
  }

}
