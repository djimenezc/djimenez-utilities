package com.djimenez.test.configuration.parser;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.HierarchicalConfiguration;

import com.djimenez.model.DefaultValues;
import com.djimenez.util.helper.DateHelper;

public class ParserConfigurations {

  private static ParserConfigurations instance;

  public static ParserConfigurations getInstance() {

    if (instance == null) {
      instance = new ParserConfigurations();
    }

    return instance;
  }

  private ParserConfigurations() {
    super();

  }

  /**
   * Return a Boolean by key of HierarchicalConfiguration if it exist
   * 
   * @param HierarchicalConfiguration
   * @param String
   *          key
   * @return value
   */
  public Boolean getBoolean(final HierarchicalConfiguration node,
    final String key) {

    Boolean data = Boolean.FALSE;
    if (node.containsKey(key)) {

      data = node.getBoolean(key);
    }
    return data;
  }

  public Date getDate(final HierarchicalConfiguration node, final String key) {

    Date date = null;

    if (node.containsKey(key)) {

      final String dateCad = node.getString(key);

      date = DateHelper.getInstance().stringToDate(dateCad).getTime();
    }

    return date;
  }

  public Date getDatetime(final HierarchicalConfiguration node, final String key) {

    Date date = null;
    if (node.containsKey(key)) {
      final String dateCad = node.getString(key);
      date = DateHelper.getInstance().stringToDateTime(dateCad).getTime();
    }
    return date;
  }

  /**
   * Return a int by key of HierarchicalConfiguration if it exist
   * 
   * @param HierarchicalConfiguration
   * @param String
   *          key
   * @return value
   */
  public Integer getInteger(final HierarchicalConfiguration node,
    final String key) {

    Integer data = Integer.valueOf(DefaultValues.DEFAULT_INT);
    if (node.containsKey(key)) {
      data = node.getInteger(key, null);
    }
    return data;
  }

  public List<String> getListString(final HierarchicalConfiguration node) {

    @SuppressWarnings("unchecked")
    final Iterator<HierarchicalConfiguration> iterator =
      node.configurationsAt("value").iterator();

    final List<String> list = new ArrayList<String>();

    while (iterator.hasNext()) {

      final HierarchicalConfiguration nodeAux = iterator.next();

      list.add(getStringValue(nodeAux));
    }

    return list;
  }

  /**
   * Return a long by key of HierarchicalConfiguration if it exist
   * 
   * @param HierarchicalConfiguration
   * @param String
   *          key
   * @return value
   */
  public Long getLong(final HierarchicalConfiguration node, final String key) {

    Long data = Long.valueOf(DefaultValues.DEFAULT_LONG);

    if (node.containsKey(key)) {
      data = node.getLong(key);
    }
    return data;
  }

  /**
   * Parse in hashMap a structure <key, value> of
   * List<HierarchicalConfiguration>
   * 
   * @param list
   * @return
   */
  public Map<Long, Long> getMap(final List<HierarchicalConfiguration> list) {

    final Iterator<HierarchicalConfiguration> iterator = list.iterator();

    final Map<Long, Long> map = new HashMap<Long, Long>();

    while (iterator.hasNext()) {

      final HierarchicalConfiguration node = iterator.next();
      map.put(getLong(node, "key"), getLong(node, "value"));
    }
    return map;
  }

  /**
   * Return a String by key of HierarchicalConfiguration if it exist
   * 
   * @param HierarchicalConfiguration
   * @param String
   *          key
   * @return value
   */
  public String getString(final HierarchicalConfiguration node, final String key) {

    String data = String.valueOf(DefaultValues.DEFAULT_STRING);

    if (node.containsKey(key)) {
      data = node.getString(key, null);
    }
    return data;
  }

  public String getStringValue(final HierarchicalConfiguration node) {

    String value = DefaultValues.ZERO_STRING;

    if (node.getRootNode() != null) {

      value = (String) node.getRootNode().getValue();
    }

    return value;
  }

}
