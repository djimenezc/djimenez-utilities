package com.djimenez.tuenti.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.Selenium;

public class SeleniumImageDownloaderTest {

  protected static Selenium selenium;
  private static SeleniumServer seleniumServer;

  @BeforeClass
  public static void setUpOnce() {

    try {
      seleniumServer = new SeleniumServer();
      seleniumServer.start();
    }
    catch (final Exception e) {
    }

    // selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.google.com");
    // selenium.start();
  }

  @AfterClass
  public static void tearDownOnce() {
    // selenium.stop();
  }

  @Test
  public final void testExecute() throws Exception {

    final SeleniumImageDownloader downloader = new SeleniumImageDownloader();

    downloader.getImage();
  }

}
