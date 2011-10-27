package com.betterprogrammer1;

import java.util.ArrayList;
import java.util.List;

public class BetterProgrammerTask3 {

  // Please do not change this interface
  public static interface Node {

    List<Node> getChildren();

    int getValue();

  }

  public static class NodeImpl implements Node {

    private int value;
    private final List<Node> childrens;

    public NodeImpl(final int i, final List<Node> childrens) {

      this.value = i;
      this.childrens = childrens;
    }

    public int addChildren(final Node node) {

      childrens.add(node);
      return 1;
    }

    @Override
    public List<Node> getChildren() {
      return childrens;
    }

    @Override
    public int getValue() {
      return value;
    }

    public void setValue(final int value) {
      this.value = value;
    }

  }

  private static Node buildNodeList() {

    final Node node1 = new NodeImpl(10, new ArrayList<Node>());
    final Node node2 = new NodeImpl(10, new ArrayList<Node>());
    final Node node3 = new NodeImpl(10, new ArrayList<Node>());
    final Node node4 = new NodeImpl(10, new ArrayList<Node>());

    final List<Node> nodeList2 = new ArrayList<Node>();
    nodeList2.add(node4);
    final Node node5 = new NodeImpl(10, nodeList2);

    final List<Node> nodeList = new ArrayList<Node>();
    nodeList.add(node1);
    nodeList.add(node2);
    nodeList.add(node3);
    nodeList.add(node5);

    final Node nodeRoot = new NodeImpl(10, nodeList);

    return nodeRoot;
  }

  public static double getAverage(final Node root) {
    /*
     * Please implement this method to return the average of all node values (Node.getValue()) in
     * the tree.
     */

    double result = 0;

    int totalSumValues = root.getValue();
    int numNodes = 0;
    double averageChildren = 0;

    for (final Node node : root.getChildren()) {
      numNodes++;

      if ((node.getChildren() != null) && (node.getChildren().size() != 0)) {

        averageChildren = getAverage(node);
      }
      else {
        totalSumValues += node.getValue();
      }
    }

    result = ((totalSumValues / numNodes) + averageChildren) / 2;

    return result;
  }

  /**
   * @param argv
   */
  public static void main(final String argv[]) {

    final Node nodeRoot = buildNodeList();

    final double result = getAverage(nodeRoot);

    final double expectResult = 10;

    if (result == expectResult) {
      System.out.println("The average value is: " + result);
    }
    else {
      System.out.println("Error, result expected: " + expectResult + ", result calculated: "
        + result);
    }
  }
}
