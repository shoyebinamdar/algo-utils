package binarytree.bst;

import binarytree.Node;
import binarytree.utils.BST;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BSTLargestTest {
    private BSTLargest bstLargest = new BSTLargest();

    @Before
    public void setup() {
        bstLargest.root = BST.insert(bstLargest.root, 4);
        bstLargest.root = BST.insert(bstLargest.root, 2);
        bstLargest.root = BST.insert(bstLargest.root, 5);
        bstLargest.root = BST.insert(bstLargest.root, 1);
        bstLargest.root = BST.insert(bstLargest.root, 3);
    }

    @Test
    public void testFind() {
        Node largestNode = bstLargest.find();
        assertEquals(bstLargest.root.right, largestNode);
        assertEquals(bstLargest.root.right.data, largestNode.data);
    }
}
