package linkedlists.singly_linked_lists;


import linkedlists.Node;

public class LinkedList {
    private Node head;
    private int size;

    public void prepend(int data) {
        Node newNode = new Node(data);

        newNode.next = head;

        head = newNode;

        size++;
    }

    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null)
            head = newNode;
        else {
            Node curr = head;

            while (curr.next != null)
                curr = curr.next;

             curr.next = newNode;
        }
        size++;
    }

    public void remove(int data) {
        Node curr = head;
        Node prev = null;

        while (curr != null && curr.data != data) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
            size--;
        }
    }

    public Node reverse() {
        Node curr = head;
        Node prev = null, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public int size() {
        return size;
    }

    public Node getHead() {
        return head;
    }
}
