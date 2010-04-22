package com.djimenez.test.configuration.util;

import org.apache.commons.configuration.HierarchicalConfiguration;

public class UtilConfiguration {

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
