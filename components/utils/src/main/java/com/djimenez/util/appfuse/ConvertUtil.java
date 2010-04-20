package com.djimenez.util.appfuse;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.djimenez.model.label.LabelValue;

/**
 * Utility class to convert one object to another.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public final class ConvertUtil {

  private static Log log = LogFactory.getLog(ConvertUtil.class);

  /**
   * Method to convert a ResourceBundle to a Map object.
   * 
   * @param rb
   *          a given resource bundle
   * @return Map a populated map
   */
  public static Map<String, String> convertBundleToMap(final ResourceBundle rb) {
    final Map<String, String> map = new HashMap<String, String>();

    final Enumeration<String> keys = rb.getKeys();
    while (keys.hasMoreElements()) {
      final String key = keys.nextElement();
      map.put(key, rb.getString(key));
    }

    return map;
  }

  /**
   * Method to convert a ResourceBundle to a Properties object.
   * 
   * @param rb
   *          a given resource bundle
   * @return Properties a populated properties object
   */
  public static Properties convertBundleToProperties(final ResourceBundle rb) {
    final Properties props = new Properties();

    for (final Enumeration<String> keys = rb.getKeys(); keys.hasMoreElements();) {
      final String key = keys.nextElement();
      props.put(key, rb.getString(key));
    }

    return props;
  }

  /**
   * Convert a java.util.List of LabelValue objects to a LinkedHashMap.
   * 
   * @param list
   *          the list to convert
   * @return the populated map with the label as the key
   */
  public static Map<String, String> convertListToMap(final List<LabelValue> list) {
    final Map<String, String> map = new LinkedHashMap<String, String>();

    for (final LabelValue option : list) {
      map.put(option.getLabel(), option.getValue());
    }

    return map;
  }

  /**
   * Convenience method used by tests to populate an object from a
   * ResourceBundle
   * 
   * @param obj
   *          an initialized object
   * @param rb
   *          a resource bundle
   * @return a populated object
   */
  public static Object populateObject(final Object obj, final ResourceBundle rb) {
    try {
      final Map<String, String> map = convertBundleToMap(rb);
      BeanUtils.copyProperties(obj, map);
    }
    catch (final Exception e) {
      log.error(e.getStackTrace());
      log.error("Exception occurred populating object: " + e.getMessage());
    }

    return obj;
  }

  /**
   * Checkstyle rule: utility classes should not have public constructor
   */
  private ConvertUtil() {
  }
}
