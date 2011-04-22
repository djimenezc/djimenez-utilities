package com.djimenez.tuenti.sikuli;

import org.junit.Test;

public class SikuliTest {

  // /**
  // * Verifies selling gifts can be cancelled in Farmville using the Sikuli test framework.
  // *
  // * @author reiks, Jan 28, 2011
  // */
  //
  // private Screen _screen;
  //
  // private void cancelSellingOfGifts() throws FindFailed {
  // _screen.click(fullPath("gift.png"), 0);
  // _screen.wait(fullPath("sell.png"), 1000);
  // _screen.click(fullPath("sell.png"), 0);
  // _screen.wait(fullPath("cancel.png"), 1000);
  // _screen.click(fullPath("cancel.png"), 0);
  // }
  //
  // private void closeChrome() throws FindFailed {
  // _screen.click(fullPath("close.png"), 0);
  // }
  //
  // private String fullPath(final String fileName) {
  // final URL url = ClassLoader.getSystemResource(fileName);
  // return url.getFile();
  // }
  //
  // private void goToURL(final String url) throws FindFailed {
  // _screen.paste(fullPath("url_bar.png"), url);
  // _screen.type(fullPath("url_bar.png"), "\n", 0);
  // }
  //
  // private void login() throws FindFailed {
  // _screen.type(fullPath("email.png"), "password\n", 0);
  // }
  //
  // private void openChrome() throws FindFailed {
  // _screen.click(fullPath("chromium-browser.png"), 0);
  // _screen.wait(fullPath("new_tab.png"));
  // }
  //
  @Test
  public void openFacebookHomepage() // throws FindFailed {
  {
    // openChrome();
    // goToURL("http://www.facebook.com/");
    // login();
    // startFarmville();
    // cancelSellingOfGifts();
    // closeChrome();
  }
  //
  // @Before
  // public void setUp() {
  // _screen = new Screen();
  // }
  //
  // private void startFarmville() throws FindFailed {
  // _screen.click(fullPath("farmville_icon.png"), 0);
  // _screen.wait(fullPath("gift.png"), 5000);
  // }
}
