package binarytree.bst;

import binarytree.Node;
import binarytree.utils.BST;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BSTSmallestTest {
    private BSTSmallest bstSmallest = new BSTSmallest();

    @Before
    public void setup() {
        bstSmallest.root = BST.insert(bstSmallest.root, 4);
        bstSmallest.root = BST.insert(bstSmallest.root, 2);
        bstSmallest.root = BST.insert(bstSmallest.root, 5);
        bstSmallest.root = BST.insert(bstSmallest.root, 1);
        bstSmallest.root = BST.insert(bstSmallest.root, 3);
    }

    @Test
    public void testFind() {
        Node smallestNode = bstSmallest.find();
        assertEquals(bstSmallest.root.left.left, smallestNode);
        assertEquals(bstSmallest.root.left.left.data, smallestNode.data);
    }

}
