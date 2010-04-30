package com.djimenez.example.spring.mvc.service.mail;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * Class for sending e-mail messages based on Velocity templates or with
 * attachments.
 * 
 * @author Matt Raible
 */
public class MailEngine {

  private final Log log = LogFactory.getLog(MailEngine.class);
  private MailSender mailSender;
  private VelocityEngine velocityEngine;
  private String defaultFrom;

  public final MailSender getMailSender() {
    return mailSender;
  }

  /**
   * Send a simple message with pre-populated values.
   * 
   * @param msg
   *          the message to send
   * @throws org.springframework.mail.MailException
   *           when SMTP server is down
   */
  public final void send(final SimpleMailMessage msg) throws MailException {
    try {
      mailSender.send(msg);
    }
    catch (final MailException ex) {
      log.error(ex.getMessage());
      throw ex;
    }
  }

  /**
   * Send a simple message based on a Velocity template.
   * 
   * @param msg
   *          the message to populate
   * @param templateName
   *          the Velocity template to use (relative to classpath)
   * @param model
   *          a map containing key/value pairs
   */
  public final void sendMessage(final SimpleMailMessage msg,
    final String templateName, final Map model) {
    String result = null;

    try {
      result =
        VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
          templateName, model);
    }
    catch (final VelocityException e) {
      e.printStackTrace();
      log.error(e.getMessage());
    }

    msg.setText(result);
    send(msg);
  }

  /**
   * Convenience method for sending messages with attachments.
   * 
   * @param recipients
   *          array of e-mail addresses
   * @param sender
   *          e-mail address of sender
   * @param resource
   *          attachment from classpath
   * @param bodyText
   *          text in e-mail
   * @param subject
   *          subject of e-mail
   * @param attachmentName
   *          name for attachment
   * @throws MessagingException
   *           thrown when can't communicate with SMTP server
   */
  public final void sendMessage(final String[] recipients, final String sender,
    final ClassPathResource resource, final String bodyText,
    final String subject, final String attachmentName)
    throws MessagingException {
    final MimeMessage message =
      ((JavaMailSenderImpl) mailSender).createMimeMessage();

    // use the true flag to indicate you need a multipart message
    final MimeMessageHelper helper = new MimeMessageHelper(message, true);

    helper.setTo(recipients);

    // use the default sending if no sender specified
    if (sender == null) {
      helper.setFrom(defaultFrom);
    }
    else {
      helper.setFrom(sender);
    }

    helper.setText(bodyText);
    helper.setSubject(subject);

    helper.addAttachment(attachmentName, resource);

    ((JavaMailSenderImpl) mailSender).send(message);
  }

  public final void setFrom(final String from) {
    this.defaultFrom = from;
  }

  public final void setMailSender(final MailSender mailSender) {
    this.mailSender = mailSender;
  }

  public final void setVelocityEngine(final VelocityEngine velocityEngine) {
    this.velocityEngine = velocityEngine;
  }
}
