package com.djimenez.util.beans;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.ResourceBundle;

import com.djimenez.util.appfuse.ConvertUtil;

public class BeanUtils {

  /**
   * Utility method to populate a javabean-style object with values from a
   * Properties file
   * 
   * @param obj
   *          the model object to populate
   * @param rb
   *          the resource bundle with the data to copy
   * @return Object populated object
   * @throws InvocationTargetException
   * @throws IllegalAccessException
   * @throws Exception
   *           if BeanUtils fails to copy properly
   */
  public static Object populate(final Object obj, final ResourceBundle rb) {

    final Map<?, ?> map = ConvertUtil.convertBundleToMap(rb);

    try {
      org.apache.commons.beanutils.BeanUtils.copyProperties(obj, map);
    }
    catch (final IllegalAccessException e) {

    }
    catch (final InvocationTargetException e) {
    }

    return obj;
  }
}
