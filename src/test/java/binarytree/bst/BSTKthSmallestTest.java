package binarytree.bst;

import binarytree.utils.BST;
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
        bstKthSmallest.root = BST.insert(bstKthSmallest.root, 4);
        bstKthSmallest.root = BST.insert(bstKthSmallest.root, 2);
        bstKthSmallest.root = BST.insert(bstKthSmallest.root, 5);
        bstKthSmallest.root = BST.insert(bstKthSmallest.root, 1);
        bstKthSmallest.root = BST.insert(bstKthSmallest.root, 3);

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
