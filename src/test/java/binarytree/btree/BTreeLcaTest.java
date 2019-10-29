package binarytree.btree;

import binarytree.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BTreeLcaTest {
    private BTreeLca bTree = new BTreeLca();

    @Before
    public void setup() {
        bTree.root = new Node(1);
        bTree.root.left = new Node(2);
        bTree.root.right = new Node(3);
        bTree.root.left.left = new Node(4);
        bTree.root.left.right = new Node(5);
        bTree.root.right.left = new Node(6);
        bTree.root.right.right = new Node(7);
    }

    @Test
    public void testLca() {
        assertEquals(1, bTree.lca(2, 3));
        assertEquals(1, bTree.lca(3, 5));
        assertEquals(3, bTree.lca(6, 7));
        assertEquals(2, bTree.lca(2, 4));
    }

    @Test
    public void testDistance() {
        assertEquals(2, bTree.distance(2, 3));
        assertEquals(3, bTree.distance(3, 5));
        assertEquals(2, bTree.distance(6, 7));
        assertEquals(1, bTree.distance(2, 4));
    }
}
