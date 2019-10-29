package binarytree.btree;

import binarytree.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BTreeTraversalTest {
  private BTreeTraversal bTreeTraversal = new BTreeTraversal();

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @Before
  public void setup() {
    bTreeTraversal.root = new Node(1);
    bTreeTraversal.root.left = new Node(2);
    bTreeTraversal.root.right = new Node(3);
    bTreeTraversal.root.left.left = new Node(4);
    bTreeTraversal.root.left.right = new Node(5);

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
    bTreeTraversal.preOrder();
    assertEquals("1\n2\n4\n5\n3\n", outContent.toString());
  }

  @Test
  public void testInOrder() {
    bTreeTraversal.inOrder();
    assertEquals("4\n2\n5\n1\n3\n", outContent.toString());
  }

  @Test
  public void testPostOrder() {
    bTreeTraversal.postOrder();
    assertEquals("4\n5\n2\n3\n1\n", outContent.toString());
  }
}
