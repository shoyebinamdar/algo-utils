package binarytree.btree;

import binarytree.Node;

public class BtreeLeftView {
    Node root;
    int maxLevel;

    public void print() {
        leftViewUtil(root, 1);
    }

    private void leftViewUtil(Node node, int level) {
        if (node == null)
            return;

        if (maxLevel < level) {
            System.out.println(node.data);
            maxLevel = level;
        }

        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }
}
