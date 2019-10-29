package binarytree.bst;

import binarytree.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BSTKthSmallestTest {
    BSTKthSmallest bstKthSmallest = new BSTKthSmallest();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup() {
        bstKthSmallest.root = new Node(4);
        bstKthSmallest.root.left = new Node(2);
        bstKthSmallest.root.right = new Node(5);
        bstKthSmallest.root.left.left = new Node(1);
        bstKthSmallest.root.left.right = new Node(3);

        System.setOut(new PrintStream(outContent));
    }

    @After
    public void reset() {
        System.setOut(originalOut);
    }

    @Test
    public void testFindSmallest() {
        bstKthSmallest.find(1);
        assertEquals("1\n", outContent.toString());
    }

    @Test
    public void testFind2ndSmallest() {
        bstKthSmallest.find(2);
        assertEquals("2\n", outContent.toString());
    }
}
