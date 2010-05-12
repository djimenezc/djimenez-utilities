package com.djimenez.example.spring.mvc.web.taglib;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.djimenez.example.spring.mvc.constants.Constants;

/**
 * Implementation of <code>TagExtraInfo</code> for the <b>constants</b> tag,
 * identifying the scripting object(s) to be made visible.
 * 
 * @author Matt Raible
 */
public class ConstantsTei extends TagExtraInfo {

  private final Log log = LogFactory.getLog(ConstantsTei.class);

  /**
   * Return information about the scripting variables to be created.
   * 
   * @param data
   *          the input data
   * @return VariableInfo array of variable information
   */
  @Override
  public final VariableInfo[] getVariableInfo(final TagData data) {
    // loop through and expose all attributes
    final List<VariableInfo> vars = new ArrayList<VariableInfo>();

    try {
      String clazz = data.getAttributeString("className");

      if (clazz == null) {
        clazz = Constants.class.getName();
      }

      final Class<?> c = Class.forName(clazz);

      // if no var specified, get all
      if (data.getAttributeString("var") == null) {
        final Field[] fields = c.getDeclaredFields();

        AccessibleObject.setAccessible(fields, true);

        for (final Field field : fields) {
          final String type = field.getType().getName();
          vars.add(new VariableInfo(field.getName(), ((field.getType()
            .isArray()) ? type.substring(2, type.length() - 1) + "[]" : type),
            true, VariableInfo.AT_END));
        }
      }
      else {
        final String var = data.getAttributeString("var");
        final String type = c.getField(var).getType().getName();
        vars.add(new VariableInfo(c.getField(var).getName(), ((c.getField(var)
          .getType().isArray()) ? type.substring(2, type.length() - 1) + "[]"
          : type), true, VariableInfo.AT_END));
      }
    }
    catch (final Exception cnf) {
      log.error(cnf.getMessage());
      cnf.printStackTrace();
    }

    return vars.toArray(new VariableInfo[] {});
  }
}