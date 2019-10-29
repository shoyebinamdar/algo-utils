package binarytree.bst;

import binarytree.Node;

public class BSTLargest {
  Node root;

  public Node find() {
    return find(root);
  }

  private Node find(Node node) {
    Node current = node;

    while (current.right != null)
      current = current.right;

    return current;
  }
}
