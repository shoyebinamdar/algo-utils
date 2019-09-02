package binarytree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {
  private BST bst = new BST();

  @Before
  public void setup() {
    bst.root = new Node(4);
    bst.root.left = new Node(2);
    bst.root.right = new Node(5);
    bst.root.left.left = new Node(1);
    bst.root.left.right = new Node(3);
  }

  @Test
  public void testSearch() {
    assertEquals(null, bst.search(6));
    assertEquals(bst.root.left.right, bst.search(3));
    assertEquals(bst.root, bst.search(4));
    assertEquals(bst.root.right, bst.search(5));
  }
}
