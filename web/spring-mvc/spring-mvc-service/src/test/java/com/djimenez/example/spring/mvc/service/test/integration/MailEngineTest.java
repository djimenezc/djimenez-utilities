package com.djimenez.example.spring.mvc.service.test.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import javax.mail.BodyPart;
import javax.mail.Part;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

import com.djimenez.example.spring.mvc.service.mail.MailEngine;

/**
 * @author Bryan Noll
 */
public class MailEngineTest extends BaseManagerIntegrationTestCase {

  @Autowired
  MailEngine mailEngine;
  @Autowired
  SimpleMailMessage mailMessage;
  JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

  @Before
  public void setUp() {
    mailSender.setHost("localhost");
    mailEngine.setMailSender(mailSender);
  }

  @After
  public void tearDown() {
    mailEngine.setMailSender(null);
  }

  @Test
  public void testSend() throws Exception {
    // mock smtp server
    final Wiser wiser = new Wiser();
    // set the port to a random value so there's no conflicts between tests
    final int port = 2525 + (int) (Math.random() * 100);
    mailSender.setPort(port);
    wiser.setPort(port);
    wiser.start();

    final Date dte = new Date();
    this.mailMessage.setTo("foo@bar.com");
    final String emailSubject = "grepster testSend: " + dte;
    final String emailBody =
      "Body of the grepster testSend message sent at: " + dte;
    this.mailMessage.setSubject(emailSubject);
    this.mailMessage.setText(emailBody);
    this.mailEngine.send(this.mailMessage);

    wiser.stop();
    assertTrue(wiser.getMessages().size() == 1);
    final WiserMessage wm = wiser.getMessages().get(0);
    assertEquals(emailSubject, wm.getMimeMessage().getSubject());
    assertEquals(emailBody, wm.getMimeMessage().getContent());
  }

  @Test
  public void testSendMessageWithAttachment() throws Exception {
    final String ATTACHMENT_NAME = "boring-attachment.txt";

    // mock smtp server
    final Wiser wiser = new Wiser();
    final int port = 2525 + (int) (Math.random() * 100);
    mailSender.setPort(port);
    wiser.setPort(port);
    wiser.start();

    final Date dte = new Date();
    final String emailSubject =
      "grepster testSendMessageWithAttachment: " + dte;
    final String emailBody =
      "Body of the grepster testSendMessageWithAttachment message sent at: "
        + dte;

    final ClassPathResource cpResource =
      new ClassPathResource("/file/test-attachment.txt");
    mailEngine.sendMessage(new String[] { "foo@bar.com" }, mailMessage
      .getFrom(), cpResource, emailBody, emailSubject, ATTACHMENT_NAME);

    wiser.stop();
    assertTrue(wiser.getMessages().size() == 1);
    final WiserMessage wm = wiser.getMessages().get(0);
    final MimeMessage mm = wm.getMimeMessage();

    final Object o = wm.getMimeMessage().getContent();
    assertTrue(o instanceof MimeMultipart);
    final MimeMultipart multi = (MimeMultipart) o;
    final int numOfParts = multi.getCount();

    boolean hasTheAttachment = false;
    for (int i = 0; i < numOfParts; i++) {
      final BodyPart bp = multi.getBodyPart(i);
      final String disp = bp.getDisposition();
      if (disp == null) { // the body of the email
        final Object innerContent = bp.getContent();
        final MimeMultipart innerMulti = (MimeMultipart) innerContent;
        assertEquals(emailBody, innerMulti.getBodyPart(0).getContent());
      }
      else
        if (disp.equals(Part.ATTACHMENT)) { // the attachment to the email
          hasTheAttachment = true;
          assertEquals(ATTACHMENT_NAME, bp.getFileName());
        }
        else {
          fail("Did not expect to be able to get here.");
        }
    }
    assertTrue(hasTheAttachment);
    assertEquals(emailSubject, mm.getSubject());
  }
}
