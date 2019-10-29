package binarytree.bst;

import binarytree.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BSTSmallestTest {
    private BSTSmallest bstSmallest = new BSTSmallest();

    @Before
    public void setup() {
        bstSmallest.root = new Node(4);
        bstSmallest.root.left = new Node(2);
        bstSmallest.root.right = new Node(5);
        bstSmallest.root.left.left = new Node(1);
        bstSmallest.root.left.right = new Node(3);
    }

    @Test
    public void testFind() {
        Node smallestNode = bstSmallest.find();
        assertEquals(bstSmallest.root.left.left, smallestNode);
        assertEquals(bstSmallest.root.left.left.data, smallestNode.data);
    }

}
