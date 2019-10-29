package binarytree.btree;

import binarytree.Node;

import java.util.ArrayList;
import java.util.List;

public class BTreeLca {
  Node root;
  List<Integer> path1 = new ArrayList<>();
  List<Integer> path2 = new ArrayList<>();

  public int lca(int n1, int n2) {
    int loc = getLcaLoc(n1, n2);

    return path1.get(loc);
  }

  public int distance(int n1, int n2) {
    int loc = getLcaLoc(n1, n2);

    return (path1.size() - (loc + 1)) + (path2.size() - (loc + 1));
  }

  private int getLcaLoc(int n1, int n2) {
    path1.clear();
    path2.clear();

    if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
      return -1;
    }

    int index;

    for (index = 0; index < path1.size(); index++) {
      if (!path1.get(index).equals(path2.get(index)))
        break;
    }

    return index - 1;
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
