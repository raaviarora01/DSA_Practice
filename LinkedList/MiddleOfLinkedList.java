/* Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node. */

package LinkedList;

/**
 * Definition for singly-linked list.
 * public class Node {
 * int val;
 * Node next;
 * Node() {}
 * Node(int val) { this.val = val; }
 * Node(int val, Node next) { this.val = val; this.next = next; }
 * }
 */
class MiddleOfLinkedList {
    // Brute force approach
    public Node middleNode(Node head) {
        int size = size(head);

        int pos = (int) Math.ceil((double) size / 2);

        Node temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }

        return temp;
    }

    // Optimal Approach (Tortoise and Hare Algo)
    public Node middleNodeOptimal(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private static int size(Node head) {
        if (head == null)
            return 0;

        Node temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        return size - 1;
    }
}
