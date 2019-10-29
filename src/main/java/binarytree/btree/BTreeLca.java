package binarytree.btree;

import binarytree.Node;

import java.util.ArrayList;
import java.util.List;

public class BTreeLca {
  Node root;

  public int lca(int n1, int n2) {

    List<Integer> path1 = new ArrayList<>();
    List<Integer> path2 = new ArrayList<>();

    if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
      return -1;
    }

    int i;

    for (i = 0; i < path1.size(); i++) {
      if (!path1.get(i).equals(path2.get(i)))
        break;
    }

    return path1.get(i - 1);
  }

  private boolean findPath(Node node, int key, List<Integer> path) {

    if (node == null)
      return false;

    path.add(node.data);

    if ((node.data == key) ||
        (node.left != null && findPath(node.left, key, path)) ||
        (node.right != null && findPath(node.right, key, path)))
      return true;

    path.remove(path.size() - 1);

    return false;
  }
}
