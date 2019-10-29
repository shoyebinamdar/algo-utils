package binarytree.bst;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BSTKthLargestTest {
    BSTKthLargest bstKthLargest = new BSTKthLargest();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup() {
        bstKthLargest.root = BSTUtils.insert(bstKthLargest.root, 4);
        bstKthLargest.root = BSTUtils.insert(bstKthLargest.root, 2);
        bstKthLargest.root = BSTUtils.insert(bstKthLargest.root, 5);
        bstKthLargest.root = BSTUtils.insert(bstKthLargest.root, 1);
        bstKthLargest.root = BSTUtils.insert(bstKthLargest.root, 3);

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
