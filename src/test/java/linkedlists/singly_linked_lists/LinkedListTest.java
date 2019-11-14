package linkedlists.singly_linked_lists;

import linkedlists.Node;
import linkedlists.utils.Utils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class LinkedListTest {
    LinkedList linkedList;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup() {
        linkedList = new LinkedList();

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        System.setOut(new PrintStream(outContent));
    }

    @After
    public void reset() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldPrintNodes() {
        Utils.print(linkedList.getHead());

        assertEquals(3, linkedList.size());
        assertEquals("1\n2\n3\n", outContent.toString());
    }

    @Test
    public void shouldPrependNodes() {
        linkedList.prepend(4);
        linkedList.prepend(5);
        linkedList.prepend(6);

        Utils.print(linkedList.getHead());

        assertEquals(6, linkedList.size());
        assertEquals("6\n5\n4\n1\n2\n3\n", outContent.toString());
    }

    @Test
    public void shouldRemoveExistingNode() {
        linkedList.remove(2);

        Utils.print(linkedList.getHead());

        assertEquals(2, linkedList.size());
        assertEquals("1\n3\n", outContent.toString());
    }

    @Test
    public void shouldRemoveNonExistingNode() {
        linkedList.remove(4);

        Utils.print(linkedList.getHead());

        assertEquals(3, linkedList.size());
        assertEquals("1\n2\n3\n", outContent.toString());
    }

    @Test
    public void shouldReverseList() {
        Utils.print(linkedList.reverse());
        assertEquals("3\n2\n1\n", outContent.toString());
    }

    @Test
    public void shouldCompareTwoIdenticalLists() {
        LinkedList linkedListToCompare = new LinkedList();
        linkedListToCompare.append(1);
        linkedListToCompare.append(2);
        linkedListToCompare.append(3);

        assertEquals(true, Utils.compare(linkedList.getHead(), linkedListToCompare.getHead()));
    }

    @Test
    public void shouldCompareTwoNonIdenticalLists() {
        LinkedList linkedListToCompare = new LinkedList();
        linkedListToCompare.append(1);
        linkedListToCompare.append(4);
        linkedListToCompare.append(3);

        assertEquals(false, Utils.compare(linkedList.getHead(), linkedListToCompare.getHead()));
    }

    @Test
    public void shouldDetectLoop() {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = node.next.next;

        assertEquals(true, Utils.hasLoop(node));

        node.next.next.next = null;

        assertEquals(false, Utils.hasLoop(node));
    }
}
