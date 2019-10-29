package binarytree.bst;

import binarytree.Node;

public class BSTKthSmallest {
  Node root;
  int count = 0;

  public void find(int k) {
    find(root, k);
  }

  private void find(Node node, int k) {
    if (node == null || count >= k)
      return;

    find(node.left, k);

    count++;

    if (count == k) {
      System.out.println(node.data);
    }

    find(node.right, k);
  }
}
