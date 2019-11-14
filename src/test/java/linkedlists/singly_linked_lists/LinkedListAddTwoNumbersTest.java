package linkedlists.singly_linked_lists;

import linkedlists.utils.Utils;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListAddTwoNumbersTest {
    @Test
    public void shouldAddTwoEqualListsLikeNumbers() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.append(5);
        list1.append(6);
        list1.append(3);

        list2.append(8);
        list2.append(4);
        list2.append(2);

        LinkedListAddTwoNumbers listAddTwoNumbers = new LinkedListAddTwoNumbers();

        LinkedList actualList = listAddTwoNumbers.add(list1, list2);

        LinkedList expectedList = new LinkedList();

        expectedList.append(1);
        expectedList.append(4);
        expectedList.append(0);
        expectedList.append(5);

        assertEquals(true, Utils.compare(expectedList.getHead(), actualList.getHead()));
    }

    @Test
    public void shouldAddTwoUnEqualListsLikeNumbers() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.append(5);
        list1.append(6);
        list1.append(3);
        list1.append(2);

        list2.append(8);
        list2.append(4);
        list2.append(2);

        LinkedListAddTwoNumbers listAddTwoNumbers = new LinkedListAddTwoNumbers();

        LinkedList actualList = listAddTwoNumbers.add(list1, list2);

        LinkedList expectedList = new LinkedList();

        expectedList.append(6);
        expectedList.append(4);
        expectedList.append(7);
        expectedList.append(4);

        assertEquals(true, Utils.compare(expectedList.getHead(), actualList.getHead()));
    }

    @Test
    public void shouldAddZeroLists() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.append(0);

        list2.append(0);

        LinkedListAddTwoNumbers listAddTwoNumbers = new LinkedListAddTwoNumbers();

        LinkedList actualList = listAddTwoNumbers.add(list1, list2);

        LinkedList expectedList = new LinkedList();

        expectedList.append(0);

        assertEquals(true, Utils.compare(expectedList.getHead(), actualList.getHead()));
    }

    @Test
    public void shouldAddZeroAndNonZeroLists() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.append(0);

        list2.append(1);
        list2.append(0);

        LinkedListAddTwoNumbers listAddTwoNumbers = new LinkedListAddTwoNumbers();

        LinkedList actualList = listAddTwoNumbers.add(list1, list2);

        LinkedList expectedList = new LinkedList();

        expectedList.append(1);
        expectedList.append(0);

        assertEquals(true, Utils.compare(expectedList.getHead(), actualList.getHead()));
    }

    @Test
    public void shouldAddTwoRandomNumbers() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.append(9);
        list1.append(9);
        list1.append(9);
        list1.append(9);

        list2.append(9);
        list2.append(9);
        list2.append(9);

        LinkedListAddTwoNumbers listAddTwoNumbers = new LinkedListAddTwoNumbers();

        LinkedList actualList = listAddTwoNumbers.add(list1, list2);

        LinkedList expectedList = new LinkedList();

        expectedList.append(1);
        expectedList.append(0);
        expectedList.append(9);
        expectedList.append(9);
        expectedList.append(8);

        assertEquals(true, Utils.compare(expectedList.getHead(), actualList.getHead()));
    }
}
