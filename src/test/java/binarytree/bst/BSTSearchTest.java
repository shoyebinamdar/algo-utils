package binarytree.bst;

import static org.junit.Assert.*;

import binarytree.Node;
import binarytree.utils.BST;
import org.junit.Before;
import org.junit.Test;

public class BSTSearchTest {
  private BSTSearch bstSearch = new BSTSearch();

  @Before
  public void setup() {
    bstSearch.root = BST.insert(bstSearch.root, 4);
    bstSearch.root = BST.insert(bstSearch.root, 2);
    bstSearch.root = BST.insert(bstSearch.root, 5);
    bstSearch.root = BST.insert(bstSearch.root, 1);
    bstSearch.root = BST.insert(bstSearch.root, 3);
  }

  @Test
  public void testSearchNotExistingElement() {
    assertEquals(null, bstSearch.search(6));
  }

  @Test
  public void testSearchRoot() {
    assertEquals(bstSearch.root, bstSearch.search(4));
  }

  @Test
  public void testSearchOnLeft() {
    Node expectedNode = new Node(3);
    assertEquals(expectedNode.data, bstSearch.search(3).data);
  }

  @Test
  public void testSearchOnRight() {
    Node expectedNode = new Node(5);
    assertEquals(expectedNode.data, bstSearch.search(5).data);
  }
}
