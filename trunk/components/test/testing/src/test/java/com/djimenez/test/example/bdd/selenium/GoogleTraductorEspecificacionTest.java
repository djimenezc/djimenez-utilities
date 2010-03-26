package com.djimenez.test.example.bdd.selenium;

import java.io.IOException;

import org.concordion.internal.ConcordionBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class GoogleTraductorEspecificacionTest {

  private static Selenium selenium;

  private static SeleniumServer seleniumServer;

  @BeforeClass
  public static void setUpOnce() throws Throwable {
    // selenium =
    // new DefaultSelenium("localhost", 4444, "*iehta",
    // "http://www.google.com");
    selenium =
      new DefaultSelenium("localhost", 4444, "*firefox",
        "http://www.google.com");

    seleniumServer = new SeleniumServer();
    seleniumServer.start();
    selenium.start();
  }

  @AfterClass
  public static void tearDownOnce() {
    selenium.stop();
    seleniumServer.stop();
  }

  @Test
  public void test() throws IOException {
    new ConcordionBuilder().build().process(this).assertIsSatisfied(this);

    // traducir("dos ideas", "español", "inglés", "two ideas");
  }

  public String traducir(final String textoATraducir,
    final String idiomaOrigen, final String idiomaDestino,
    final String textoTraducido) {

    selenium.open("http://www.google.com/language_tools?hl=es");

    // selenium.click("//table[2]/tbody/tr/td/font");
    // selenium
    // .select("//td[@id='submitcell']/select[1]", "label=" + idiomaOrigen);
    // selenium.type("source", textoATraducir);
    // selenium.select("//td[@id='submitcell']/select[2]", "label="
    // + idiomaDestino);
    // selenium.click("//input[@value='Traducir']");

    selenium.waitForPageToLoad("30000");

    // selenium.click("link=Herramientas del idioma");
    // selenium.waitForPageToLoad("30000");
    selenium.select("sl", "label=" + idiomaOrigen);
    selenium.select("tl", "label=" + idiomaDestino);
    selenium.type("source", textoATraducir);
    selenium.click("//input[@value='Traducir']");
    selenium.waitForPageToLoad("30000");

    selenium.waitForPageToLoad("100000");
    if (selenium.isTextPresent(textoTraducido)) {
      return "OK";
    }
    else {
      return "ERROR";
    }
  }
}
