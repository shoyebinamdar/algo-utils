package binarytree.bst;

import binarytree.Node;

public class BSTSearch {
  Node root;

  public Node search(Integer key) {
    return search(root, key);
  }

  private Node search(Node node, Integer key) {
    if (node == null || key == node.data)
      return node;

    if (key < node.data)
      return search(node.left, key);

    return search(node.right, key);
  }
}
