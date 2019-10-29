package binarytree.btree;

import binarytree.Node;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BtreeLeftViewTest {
    private BtreeLeftView btreeLeftView = new BtreeLeftView();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        btreeLeftView.root = new Node(1);
        btreeLeftView.root.left = new Node(2);
        btreeLeftView.root.right = new Node(3);
        btreeLeftView.root.left.left = new Node(4);
        btreeLeftView.root.left.right = new Node(5);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testLeftView() {
        btreeLeftView.print();
        assertEquals("1\n2\n4\n", outContent.toString());
    }
}
