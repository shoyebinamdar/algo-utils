package linkedlists.singly_linked_lists;

import linkedlists.Node;

public class LinkedListAddTwoNumbers {
    private LinkedList result = new LinkedList();
    int carry;

    public LinkedList add(LinkedList list1, LinkedList list2) {
        if (list1.size() == list2.size()) {
            addEqualLists(list1.getHead(), list2.getHead());
        } else {
            if (list1.size() > list2.size()) {
                addUnequalLists(list1, list2);
            } else {
                addUnequalLists(list2, list1);
            }
        }

        if (carry > 0)
            result.prepend(carry);

        return result;
    }

    private void addEqualLists(Node node1, Node node2) {
        if (node1 == null && node2 == null && carry == 0)
            return;

        addEqualLists(node1.next, node2.next);

        int sum = node1.data + node2.data + carry;
        carry = sum / 10;

        result.prepend(sum % 10);
    }

    private void addUnequalLists(LinkedList list1, LinkedList list2) {
        int diff = list1.size() - list2.size();
        int cnt = 0;

        LinkedList tempList = new LinkedList();
        Node curr = list1.getHead();
        while (curr != null && cnt < list1.size()) {
            if (cnt >= diff)
                tempList.append(curr.data);
            else
                cnt++;

            curr = curr.next;
        }

        addEqualLists(tempList.getHead(), list2.getHead());

        int i = 0;

        curr = list1.getHead();

        while (i < diff) {
            int sum = curr.data + carry;
            carry = sum / 10;
            result.prepend(sum % 10);

            i++;
            curr = curr.next;
        }
    }
}
