package com.gowex.twitter.facade;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class TwitterFacadeImpl {

  private final Twitter twitter;

  public TwitterFacadeImpl() {

    twitter = new TwitterFactory().getInstance();

  }

}
