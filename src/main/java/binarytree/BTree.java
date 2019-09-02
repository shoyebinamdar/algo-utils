package binarytree;

public class BTree {
  Node root;

  BTree() {
    root = null;
  }

  public void inOrder() {
    this.inOrder(root);
  }

  public void preOrder() {
    this.preOrder(root);
  }

  public void postOrder() {
    this.postOrder(root);
  }

  private void inOrder(Node root) {
    if (root != null) {
      inOrder(root.left);
      System.out.println(root.data);
      inOrder(root.right);
    }
  }

  private void preOrder(Node root) {
    if (root != null) {
      System.out.println(root.data);
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  private void postOrder(Node root) {
    if (root != null) {
      postOrder(root.left);
      postOrder(root.right);
      System.out.println(root.data);
    }
  }
}
