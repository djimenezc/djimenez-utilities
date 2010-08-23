package com.gowex.sms.sent.example.test;

import static org.junit.Assert.assertNotNull;

import org.apache.commons.httpclient.NameValuePair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gowex.sms.sent.example.command.HttpCommand;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/test-applicationContext.xml" })
public class CommandHttpTest {

  @Autowired
  private HttpCommand httpCommand;

  private NameValuePair[] configRequestCreditAvailableParameters() {

    final NameValuePair[] parametersList = new NameValuePair[4];

    // Se crea la lista de par´metros a enviar en la petici´n POST
    // XX, YY y ZZ se corresponden con los valores de identificaci´n del
    // usuario en el sistema.
    parametersList[0] = new NameValuePair("cmd", "getcredit");
    parametersList[1] = new NameValuePair("domainId", "comercial");
    parametersList[2] = new NameValuePair("login", "gowex");
    parametersList[3] = new NameValuePair("passwd", "vtwibjyj");
    // parametersList[4] = new NameValuePair("dest", "34615893501");
    // parametersList[5] = new NameValuePair("senderId", "gowex");
    // parametersList[6] = new NameValuePair("msg", "Texto de prueba Gowex");

    return parametersList;
  }

  private NameValuePair[] configRequestSentSmsParameters() {

    final NameValuePair[] parametersList = new NameValuePair[7];

    // Se crea la lista de par´metros a enviar en la petici´n POST
    // XX, YY y ZZ se corresponden con los valores de identificaci´n del
    // usuario en el sistema.
    parametersList[0] = new NameValuePair("cmd", "sendsms");
    parametersList[1] = new NameValuePair("domainId", "comercial");
    parametersList[2] = new NameValuePair("login", "gowex");
    parametersList[3] = new NameValuePair("passwd", "vtwibjyj");
    parametersList[4] = new NameValuePair("dest", "34615893501");
    parametersList[5] = new NameValuePair("senderId", "gowex");
    parametersList[6] = new NameValuePair("msg", "Texto de prueba Gowex");

    return parametersList;
  }

  @Test
  public final void testResquestCreditAvailableExecute() {

    httpCommand.setParameters(configRequestCreditAvailableParameters());
    final int commandCode = httpCommand.execute();

    if (commandCode == 1) {
      System.out.println("Response-> " + httpCommand.getResponse());
    }
    else {
      assertNotNull(null);
    }

  }

  @Test
  public final void testResquestSentSmsExecute() {

    httpCommand.setParameters(configRequestSentSmsParameters());
    httpCommand.execute();

    System.out.println("Response-> " + httpCommand.getResponse());
  }
}
