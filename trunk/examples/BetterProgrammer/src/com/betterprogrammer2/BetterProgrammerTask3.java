package com.betterprogrammer2;

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

  public static void main(final String argv[]) throws Exception {

    final List<Node> nodeList = traverseTreeInDepth(buildNodeList());

    System.out.println("The list size is: " + nodeList.size());
  }

  public static List<Node> traverseTreeInDepth(final Node root) throws Exception {
    /*
     * Please implement this method to traverse the tree in depth and return a list of all passed
     * nodes. The method shall work optimally with large trees.
     */

    final List<Node> result = new ArrayList<Node>();

    result.add(root);

    for (final Node node : root.getChildren()) {

      final List<Node> nodesFromChilden = traverseTreeInDepth(node);

      final boolean checkValue = result.addAll(nodesFromChilden);

      if (!checkValue) {
        throw new Exception("Error concatening list");
      }
    }

    return result;
  }
}
