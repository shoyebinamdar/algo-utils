package binarytree.btree;

import binarytree.NodeWithHd;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BtreeBottomView {
    NodeWithHd root;

    public void print() {
        if (root == null)
            return;

        Queue<NodeWithHd> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();

        NodeWithHd node = root;

        int hd = 0;
        node.hd = hd;
        queue.add(node);

        while (!queue.isEmpty()) {
            hd = node.hd;

            map.put(hd, node.data);

            if (node.left != null) {
                node.left.hd = hd - 1;
                queue.add(node.left);
            }

            if (node.right != null) {
                node.right.hd = hd + 1;
                queue.add(node.right);
            }

            node = queue.poll();
        }

        for (Integer val : map.values()) {
            System.out.println(val);
        }
    }
}
