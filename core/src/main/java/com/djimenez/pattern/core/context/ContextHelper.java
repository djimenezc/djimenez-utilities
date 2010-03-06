package com.djimenez.pattern.core.context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * <p>
 * Application data contex helper class. This class requires
 * <i>n2a-context.properties</i>
 * </p>
 * <p>
 * Note: N2A will never run if <i>ContextHelper</i> fails
 * </p>
 * 
 * @author djimenez
 * @author sara.gonzalez.ming
 * @version 1.3
 * @since 2.1
 */
public final class ContextHelper {

  private static final Logger logger = Logger.getLogger(ContextHelper.class);
  private static final String PROPERTIES_FILE_NAME = "n2a-context.properties";

  private static ContextHelper instance;

  private Properties properties;

  private String postErrorMediatorNotification;

  public ContextHelper() {
    this.loadBundle();
  }

  private void loadBundle() {
    this.properties = new Properties();
    try {
      final InputStream inputStream =
        ContextHelper.class.getClassLoader().getResourceAsStream(
          PROPERTIES_FILE_NAME);
      this.properties.load(inputStream);
      logger.debug("Found properties file " + PROPERTIES_FILE_NAME);
      this.printContextProperties();
    }
    catch (final IOException e) {
      logger.error(e.getMessage(), e);
      throw new ContextLoadingException(e.getMessage(), e.getCause());
    }
  }

  private void printContextProperties() {
    logger.info("*** LOADING WORKSTATION CONTEXT ***");
    logger.info("[Context] Workstation :" + this.getWorkstation());
    logger.info("[Context] WorkstationMaster :" + this.isWorkstationMaster());
    logger.info("[Context] Site :" + this.getSite());
    logger.info("[Context] Site Version :" + this.getSiteVersion());
    logger.info("[Context] MaxItemIdLengthConst :"
      + this.getMaxItemIdLengthConst());
    logger.info("[Context] JournalActive :" + this.isJournalActive());
    logger.info("[Context] ElectronicJournalActive :"
      + this.isElectronicJournalActive());
    logger.info("[Context] SlipActive :" + this.isSlipActive());
    logger.info("[Context] Loyalty Store :" + this.isLoyaltyStore());
    logger.info("[Context] Log Detailed Order :"
      + this.isLoggingDetailedOrder());
    logger.info("[Context] Franchised :" + this.isFranchised());
    logger.info("[Context] DecimalStatusFlag :" + this.getDecimalStatusFlag());
    logger.info("[Context] DcsSimulated :" + this.isDcsSimulated());
    logger.info("[Context] DcsSimulatedResultOK :"
      + this.isDcsSimulatedResultOK());
    logger.info("[Context] DefaultOperatorId :" + this.getDefaultOperatorId());
    logger.info("*** **** ***** **** ***");
  }

  public static final ContextHelper getInstance() {
    if (instance == null) {
      instance = new ContextHelper();
    }
    return instance;
  }

  private String getProperty(final String key) {
    return this.properties.getProperty(key);
  }

  private Long getLong(final String key) {
    final String value = this.properties.getProperty(key);
    return Long.valueOf(value);
  }

  private Boolean getBoolean(final String key) {
    final String value = this.properties.getProperty(key);
    return Boolean.valueOf(value);
  }

  public Long getWorkstation() {
    return this.getLong("workstation");
  }

  public Boolean isWorkstationMaster() {
    return this.getBoolean("workstationMaster");
  }

  public String getSite() {
    return this.getProperty("site");
  }

  public Long getMaxItemIdLengthConst() {
    return this.getLong("maxItemIdLengthConst");
  }

  public Boolean isJournalActive() {
    return this.getBoolean("journalActive");
  }

  public Boolean isElectronicJournalActive() {
    return this.getBoolean("electronicJournalActive");
  }

  public Boolean isSlipActive() {
    return this.getBoolean("slipActive");
  }

  public String getSiteVersion() {
    return this.getProperty("siteVersion");
  }

  public Boolean isLoyaltyStore() {
    return this.getBoolean("loyaltyStore");
  }

  public Boolean isLoggingDetailedOrder() {
    return this.getBoolean("logDetailedOrder");
  }

  public String getPostErrorMediatorNotification() {
    return this.postErrorMediatorNotification;
  }

  public void setPostErrorMediatorNotification(
    final String postErrorMediatorNotification) {
    this.postErrorMediatorNotification = postErrorMediatorNotification;
  }

  public Boolean isFranchised() {
    return this.getBoolean("franchised");
  }

  public Boolean getDecimalStatusFlag() {
    return this.getBoolean("decimalStatusFlag");
  }

  public Boolean isDcsSimulated() {
    return this.getBoolean("dcsSimulated");
  }

  public Boolean isDcsSimulatedResultOK() {
    return this.getBoolean("dcsSimulatedResultOK");
  }

  public Long getDefaultOperatorId() {
    return this.getLong("defaultOperatorId");
  }

}
