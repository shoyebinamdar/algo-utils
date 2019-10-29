package binarytree.bst;

import binarytree.Node;

public class BSTSmallest {
  Node root;

  public Node find() {
    return find(root);
  }

  private Node find(Node node) {
    Node current = node;

    while (current.left != null)
      current = current.left;

    return current;
  }
}
