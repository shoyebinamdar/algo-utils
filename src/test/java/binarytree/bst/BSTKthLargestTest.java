package binarytree.bst;

import binarytree.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BSTKthLargestTest {
    BSTKthLargest bstKthLargest = new BSTKthLargest();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup() {
        bstKthLargest.root = new Node(4);
        bstKthLargest.root.left = new Node(2);
        bstKthLargest.root.right = new Node(5);
        bstKthLargest.root.left.left = new Node(1);
        bstKthLargest.root.left.right = new Node(3);

        System.setOut(new PrintStream(outContent));
    }

    @After
    public void reset() {
        System.setOut(originalOut);
    }

    @Test
    public void testFindLargest() {
        bstKthLargest.find(1);
        assertEquals("5\n", outContent.toString());
    }

    @Test
    public void testFind2ndLargest() {
        bstKthLargest.find(2);
        assertEquals("4\n", outContent.toString());
    }
}
