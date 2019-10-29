package binarytree.btree;

import binarytree.Node;
import binarytree.NodeWithHd;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BtreeTopViewTest {
    BtreeTopView btreeTopView = new BtreeTopView();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        btreeTopView.root = new NodeWithHd(1);
        btreeTopView.root.left = new NodeWithHd(2);
        btreeTopView.root.right = new NodeWithHd(3);
        btreeTopView.root.left.left = new NodeWithHd(4);
        btreeTopView.root.left.right = new NodeWithHd(5);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testTopView() {
        btreeTopView.print();
        assertEquals("4\n2\n1\n3\n", outContent.toString());
    }
}
