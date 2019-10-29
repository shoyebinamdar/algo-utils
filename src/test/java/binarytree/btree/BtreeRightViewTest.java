package binarytree.btree;

import binarytree.Node;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BtreeRightViewTest {
    private BtreeRightView btreeRightView = new BtreeRightView();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        btreeRightView.root = new Node(1);
        btreeRightView.root.left = new Node(2);
        btreeRightView.root.right = new Node(3);
        btreeRightView.root.left.left = new Node(4);
        btreeRightView.root.left.right = new Node(5);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testRightView() {
        btreeRightView.print();
        assertEquals("1\n3\n5\n", outContent.toString());
    }
}
