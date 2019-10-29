package binarytree.btree;

import binarytree.NodeWithHd;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BtreeBottomViewTest {
    BtreeBottomView btreeBottomView = new BtreeBottomView();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        btreeBottomView.root = new NodeWithHd(1);
        btreeBottomView.root.left = new NodeWithHd(2);
        btreeBottomView.root.right = new NodeWithHd(3);
        btreeBottomView.root.left.left = new NodeWithHd(4);
        btreeBottomView.root.left.right = new NodeWithHd(5);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testBottomView() {
        btreeBottomView.print();
        assertEquals("4\n2\n5\n3\n", outContent.toString());
    }
}
