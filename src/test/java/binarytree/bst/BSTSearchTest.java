package binarytree.bst;

import static org.junit.Assert.*;

import binarytree.Node;
import org.junit.Before;
import org.junit.Test;

public class BSTSearchTest {
  private BSTSearch bstSearch = new BSTSearch();

  @Before
  public void setup() {
    bstSearch.root = new Node(4);
    bstSearch.root.left = new Node(2);
    bstSearch.root.right = new Node(5);
    bstSearch.root.left.left = new Node(1);
    bstSearch.root.left.right = new Node(3);
  }

  @Test
  public void testSearch() {
    assertEquals(null, bstSearch.search(6));
    assertEquals(bstSearch.root.left.right, bstSearch.search(3));
    assertEquals(bstSearch.root, bstSearch.search(4));
    assertEquals(bstSearch.root.right, bstSearch.search(5));
  }
}
