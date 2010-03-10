package com.djimenez.testing.configuration.retrieve;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.HierarchicalConfiguration.Node;

public class RetrieveConfiguration {

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
   * Method recovery an test case HierarchicalConfiguration of node in the xml
   * file name by its name
   * 
   * @param file
   * @param nodeName
   * @return null if the node with the attribute name is equal to the parameter
   *         nodeName
   * @throws ConfigurationException
   * @throws org.apache.commons.configuration.ConfigurationException
   */
  public static HierarchicalConfiguration getTestCaseHierarchicalConfiguration(
    final String file, final String nodeName)
    throws org.apache.commons.configuration.ConfigurationException {

    final String tag = "testcases.testcase";

    final XMLConfiguration xmlConfiguration = new XMLConfiguration(file);

    return getHierarchicalConfiguration(xmlConfiguration, nodeName, tag);
  }
}
