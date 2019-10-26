package binarytree.btree;

import binarytree.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BTreeTest {
  private BTree bTree = new BTree();

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @Before
  public void setup() {
    bTree.root = new Node(1);
    bTree.root.left = new Node(2);
    bTree.root.right = new Node(3);
    bTree.root.left.left = new Node(4);
    bTree.root.left.right = new Node(5);

    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @After
  public void reset() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test
  public void testPreOrder() {
    bTree.preOrder();
    assertEquals("1\n2\n4\n5\n3\n", outContent.toString());
  }

  @Test
  public void testInOrder() {
    bTree.inOrder();
    assertEquals("4\n2\n5\n1\n3\n", outContent.toString());
  }

  @Test
  public void testPostOrder() {
    bTree.postOrder();
    assertEquals("4\n5\n2\n3\n1\n", outContent.toString());
  }
}
