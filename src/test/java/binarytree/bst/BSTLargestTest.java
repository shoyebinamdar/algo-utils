package binarytree.bst;

import binarytree.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BSTLargestTest {
    private BSTLargest bstLargest = new BSTLargest();

    @Before
    public void setup() {
        bstLargest.root = new Node(4);
        bstLargest.root.left = new Node(2);
        bstLargest.root.right = new Node(5);
        bstLargest.root.left.left = new Node(1);
        bstLargest.root.left.right = new Node(3);
    }

    @Test
    public void testFind() {
        Node largestNode = bstLargest.find();
        assertEquals(bstLargest.root.right, largestNode);
        assertEquals(bstLargest.root.right.data, largestNode.data);
    }
}
