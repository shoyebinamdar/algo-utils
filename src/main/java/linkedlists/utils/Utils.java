package linkedlists.utils;

import linkedlists.Node;

public class Utils {
    public static boolean compare(Node n1, Node n2) {
        Node c1 = n1;
        Node c2 = n2;

        while (c1 != null && c2 != null && c1.data == c2.data) {
            c1 = c1.next;
            c2 = c2.next;
        }

        return c1 == null && c2 == null;
    }

    public static void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
