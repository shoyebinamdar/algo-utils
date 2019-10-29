package binarytree.btree;

import binarytree.Node;

public class BtreeRightView {
    Node root;
    int maxLevel;

    public void print() {
        rightViewUtil(root, 1);
    }

    private void rightViewUtil(Node node, int level) {
        if (node == null)
            return;

        if (maxLevel < level) {
            System.out.println(node.data);
            maxLevel = level;
        }

        rightViewUtil(node.right, level + 1);
        rightViewUtil(node.left, level + 1);
    }
}
