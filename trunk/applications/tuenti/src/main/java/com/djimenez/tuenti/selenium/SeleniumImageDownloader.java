package com.djimenez.tuenti.selenium;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;

public class SeleniumImageDownloader {

  public static void main(final String[] args) throws Exception {

    SeleniumServer seleniumServer;

    try {
      seleniumServer = new SeleniumServer();
      seleniumServer.start();
    }
    catch (final Exception e) {
    }

    final SeleniumImageDownloader downloader = new SeleniumImageDownloader();

    downloader.getImage();
  }

  public void getImage() throws Exception {
    String[] commands = new String[] {};
    final String AutoItScriptpath = "/home/david/tmp/saveImage.exe";
    commands = new String[] { AutoItScriptpath };
    Runtime.getRuntime().exec(commands);

    final DefaultSelenium selenium =
      new DefaultSelenium("localhost", 4444, "*firefox", "http://www.testingexcellence.com");
    selenium.start();
    selenium.open("wp-content/themes/thesis/custom/images/logo.jpg");
    selenium.windowMaximize();

    // native key strokes for CTRL and S keys
    final Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_S);
    robot.keyRelease(KeyEvent.VK_S);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_ACCEPT);
    robot.keyRelease(KeyEvent.VK_ACCEPT);
    // once the dialog box is displayed, the autoIt script
    // will fire off and send an Enter command.
  }
}
