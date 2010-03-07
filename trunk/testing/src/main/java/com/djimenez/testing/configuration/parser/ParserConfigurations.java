package com.djimenez.testing.configuration.parser;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.HierarchicalConfiguration.Node;

import com.djimenez.model.DefaultValues;
import com.djimenez.util.helper.DateHelperFO;

public class ParserConfigurations {

  public static final int NUMBER_DEFAULT = 0;
  public static final String STRING_DEFAULT = "";

  /**
   * Return a Boolean by key of HierarchicalConfiguration if it exist
   * 
   * @param HierarchicalConfiguration
   * @param String
   *          key
   * @return value
   */
  public static Boolean getBoolean(final HierarchicalConfiguration sub,
    final String key) {

    Boolean data = Boolean.FALSE;
    if (sub.containsKey(key)) {

      data = sub.getBoolean(key);
    }
    return data;
  }

  public static Date getDate(final HierarchicalConfiguration sub,
    final String key) {

    Date date = null;

    if (sub.containsKey(key)) {

      final String dateCad = sub.getString(key);
      date = DateHelperFO.stringToDate(dateCad).getTime();
    }

    return date;
  }

  public static Date getDatetime(final HierarchicalConfiguration sub,
    final String key) {

    Date date = null;
    if (sub.containsKey(key)) {
      final String dateCad = sub.getString(key);
      date = DateHelperFO.stringToDateTime(dateCad).getTime();
    }
    return date;
  }

  /**
   * Method recovery an HierarchicalConfiguration of node in the xml file name
   * by its position
   * 
   * @param file
   * @param nodePosition
   *          Indicate the node position in the test
   * @param tag
   * @return
   * @throws ConfigurationException
   */
  public static HierarchicalConfiguration getHierarchicalConfiguration(
    final String file, final int nodePosition, final String tag)
    throws ConfigurationException {

    final XMLConfiguration xml = new XMLConfiguration(file);

    @SuppressWarnings("unchecked")
    final List<HierarchicalConfiguration> sub = xml.configurationsAt(tag);

    final HierarchicalConfiguration data = sub.get(nodePosition);

    return data;
  }

  /**
   * Method recovery an HierarchicalConfiguration of node in the xml file name
   * by its name
   * 
   * @param file
   * @param nodeName
   * @param tag
   * @return null if the node with the attribute name is equal to the parameter
   *         nodeName
   * @throws ConfigurationException
   * @throws org.apache.commons.configuration.ConfigurationException
   */
  public static HierarchicalConfiguration getHierarchicalConfiguration(
    final String file, final String nodeName, final String tag)
    throws org.apache.commons.configuration.ConfigurationException {

    final XMLConfiguration xmlConfiguration = new XMLConfiguration(file);

    return getHierarchicalConfiguration(xmlConfiguration, nodeName, tag);
  }

  /**
   * Method recovery an HierarchicalConfiguration of node in the xml file name
   * by its name
   * 
   * @param xmlConfiguration
   * @param nodeName
   * @param tag
   * @return null if the node with the attribute name is equal to the parameter
   *         nodeName
   * @throws ConfigurationException
   */
  public static HierarchicalConfiguration getHierarchicalConfiguration(
    final XMLConfiguration xmlConfiguration, final String nodeName,
    final String tag) throws ConfigurationException {

    @SuppressWarnings("unchecked")
    final List<HierarchicalConfiguration> sub =
      xmlConfiguration.configurationsAt(tag);

    HierarchicalConfiguration data;
    HierarchicalConfiguration dataReturn = null;

    final Iterator<HierarchicalConfiguration> nodeIterator = sub.iterator();

    for (final Iterator<HierarchicalConfiguration> iterator = nodeIterator; iterator
      .hasNext();) {

      data = iterator.next();

      if (!data.getRoot().getAttributes().isEmpty()) {

        final HierarchicalConfiguration.Node nodeAttributes =
          (Node) data.getRoot().getAttributes().get(0);

        if (nodeAttributes.getName().equals("name")
          && nodeAttributes.getValue().equals(nodeName)) {
          dataReturn = data;
        }
      }
    }

    return dataReturn;
  }

  /**
   * Return a int by key of HierarchicalConfiguration if it exist
   * 
   * @param HierarchicalConfiguration
   * @param String
   *          key
   * @return value
   */
  public static Integer getInteger(final HierarchicalConfiguration sub,
    final String key) {

    Integer data = Integer.valueOf(NUMBER_DEFAULT);
    if (sub.containsKey(key)) {
      data = sub.getInteger(key, null);
    }
    return data;
  }

  public static List<String> getListString(
    final HierarchicalConfiguration hierarchicalConfiguration) {

    @SuppressWarnings("unchecked")
    final Iterator<HierarchicalConfiguration> iterator =
      hierarchicalConfiguration.configurationsAt("value").iterator();

    final List<String> list = new ArrayList<String>();

    while (iterator.hasNext()) {

      final HierarchicalConfiguration node = iterator.next();

      list.add(ParserConfigurations.getStringValue(node));
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
  public static Long getLong(final HierarchicalConfiguration sub,
    final String key) {

    Long data = Long.valueOf(NUMBER_DEFAULT);

    if (sub.containsKey(key)) {
      data = sub.getLong(key);
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
  public static Map<Long, Long> getMap(
    final List<HierarchicalConfiguration> list) {

    final Iterator<HierarchicalConfiguration> iterator = list.iterator();

    final Map<Long, Long> map = new HashMap<Long, Long>();

    while (iterator.hasNext()) {

      final HierarchicalConfiguration node = iterator.next();
      map.put(ParserConfigurations.getLong(node, "key"), ParserConfigurations
        .getLong(node, "value"));
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
  public static String getString(final HierarchicalConfiguration sub,
    final String key) {

    String data = String.valueOf(STRING_DEFAULT);

    if (sub.containsKey(key)) {
      data = sub.getString(key, null);
    }
    return data;
  }

  private static String getStringValue(final HierarchicalConfiguration node) {

    String value = DefaultValues.ZERO_STRING;

    if (node.getRootNode() != null) {

      value = (String) node.getRootNode().getValue();
    }

    return value;
  }

  /**
   * Method that check if a xml node have a child with the key name
   * 
   * @param node
   *          xml node where it is searched
   * @param name
   *          child key name to search
   * @return true if the xml node have a child with the same key value that
   *         param name
   */
  public static boolean isExistChild(final HierarchicalConfiguration node,
    final String name) {

    Boolean response = false;

    if (!node.getRoot().getChildren(name).isEmpty()) {
      response = true;
    }

    return response;
  }

  /**
   * Method that check if a xml node have a list of nodes with the key name
   * 
   * @param node
   *          xml node where it is searched
   * @param name
   *          key name to search
   * @return true if the xml node have a list of nodes with the same key value
   *         that param name
   */
  public static boolean isListEmpty(final HierarchicalConfiguration node,
    final String nodeName) {

    Boolean response = false;

    if (node.configurationsAt(nodeName).isEmpty()) {
      response = true;
    }

    return response;
  }

  /**
   * Method that check if a xml node have the name passes as paramerter
   * 
   * @param node
   *          xml node where it is searched
   * @param name
   *          key name to search
   * @return true if the xml node have the name with the same key value that
   *         param name
   */
  public static boolean isNodeName(final HierarchicalConfiguration node,
    final String nodeName) {

    Boolean response = false;

    if (node.getRoot().getName().equals(nodeName)) {
      response = true;
    }

    return response;
  }
}
